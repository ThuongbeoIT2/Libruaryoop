package com.example.libruaryoop;

import com.example.libruaryoop.Model.NhanSu;
import com.example.libruaryoop.Repository.NhanSuRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class LoginRepoTest {
    @Autowired
    private NhanSuRepo nhanSuRepo;
    @Test
    public void testRegister() throws RuntimeException{

        NhanSu nhanSu1 = new NhanSu();
        nhanSu1.setHoTen("Thuong");
        nhanSu1.setSoDienThoai("0123456789");
        nhanSu1.setUsername("Thuong@gmail.com");
        nhanSu1.setPassword("1234");
        nhanSu1.setRole("admin");
        nhanSu1.setCheckUser(false);
        nhanSuRepo.save(nhanSu1);
       // Đăng ký
        NhanSu regis= new NhanSu();
        regis.setHoTen("Duy Thuong");
        regis.setSoDienThoai("0123456889");
        regis.setUsername("Thuong@gmail.com");
        regis.setPassword("12346");
        regis.setRole("admin");
        regis.setCheckUser(false);
        ///
        NhanSu foundUser= nhanSuRepo.findByUsername(regis.getUsername());
        if(foundUser!=null){
            throw new RuntimeException("Tại khoan da ton tai.Yeu cau chinh sua lai!");
        }
        else {
            nhanSuRepo.save(regis);
        }
    }
@Test
    public void testLogin() throws RuntimeException{

        NhanSu nhanSu1 = new NhanSu();
        nhanSu1.setHoTen("Thuong");
        nhanSu1.setSoDienThoai("0123456789");
        nhanSu1.setUsername("Thuong@gmail.com");
        nhanSu1.setPassword("1234");
        nhanSu1.setRole("admin");
        nhanSu1.setCheckUser(false);
        nhanSuRepo.save(nhanSu1);
        // Đăng nhập từ form gửi lên
        NhanSu regis= new NhanSu();
        regis.setUsername("Thuong@gmail.com");
        regis.setPassword("12346");
        ///
        NhanSu foundUser= nhanSuRepo.findByUsername(regis.getUsername());
        if(foundUser==null){
            throw new RuntimeException("Tại khoan khong ton tai.Yeu cau dang nhap lai!");
        }
        else {
           if(foundUser.getPassword().equals(regis.getPassword())){
               throw new RuntimeException("Đang nhap thanh cong");
           }
           else {
               throw new RuntimeException("Mat khau khong chinh xác");
           }
        }
    }
}
