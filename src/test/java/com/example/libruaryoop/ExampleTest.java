package com.example.libruaryoop;

import com.example.libruaryoop.Model.NhanSu;
import com.example.libruaryoop.Repository.NhanSuRepo;
import com.example.libruaryoop.exception.UserException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ExampleTest {
    @Autowired
    private NhanSuRepo nhanSuRepo;
    @Test
    public void testStringContainsSubstring() {
        String str = "Hello, world!";
        Assertions.assertThat(str).contains("world");
    }
    @Test
    public void testFindUserById() {
        // Tạo một người dùng mới với ID là 100
        NhanSu user = new NhanSu();
        user.setUser_id(100L);
        user.setUsername("Thuong@gmail.com");
        user.setHoTen("Duy Thuong");
        user.setCheckUser(true);
        user.setPassword("thuong123");
        user.setSoDienThoai("0326466232");
        user.setRole("admin");

        // Thêm người dùng mới vào trong cơ sở dữ liệu
        nhanSuRepo.save(user);
        // Tìm kiếm người dùng với ID là 100 và kiểm tra xem thông tin của người dùng trả về có đúng không
        NhanSu foundUser= nhanSuRepo.findById(100L).orElse(null);
        if(foundUser!=null){
            Assertions.assertThat(foundUser.getRole().equalsIgnoreCase("admin"));
            Assertions.assertThat(foundUser.getUsername().equalsIgnoreCase("DuyThuong@gmail.com"));
            Assertions.assertThat(foundUser.getPassword().equalsIgnoreCase("thuong123"));
            Assertions.assertThat(foundUser.getSoDienThoai().equalsIgnoreCase("0326466232"));
            Assertions.assertThat(foundUser.getHoTen().equalsIgnoreCase("Duy Thuong"));
        } else {
            throw new UserException("Không tồn tại user có user_id vừa nhập! ");
        }
    }


}
