package com.example.libruaryoop;

import com.example.libruaryoop.Model.NhanSu;
import com.example.libruaryoop.Repository.NhanSuRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class NhanSuRepoTest {

    @Autowired
    private NhanSuRepo nhanSuRepo;

    @Test
    public void testFindAllCheckTrue() {

        NhanSu nhanSu1 = new NhanSu();
        nhanSu1.setHoTen("Thuong");
        nhanSu1.setSoDienThoai("0123456789");
        nhanSu1.setUsername("Thuong@gmail.com");
        nhanSu1.setPassword("1234");
        nhanSu1.setRole("admin");
        nhanSu1.setCheckUser(true);
        nhanSuRepo.save(nhanSu1);
        NhanSu nhanSu2 = new NhanSu();
        nhanSu2.setHoTen("ThuongDuy");
        nhanSu2.setSoDienThoai("0123457789");
        nhanSu2.setUsername("DuyThuong@gmail.com");
        nhanSu2.setPassword("12345");
        nhanSu2.setRole("admin");
        nhanSu2.setCheckUser(false);
        nhanSuRepo.save(nhanSu2);
        List<NhanSu> result = nhanSuRepo.findAllCheckTrue();
        assertThat(result).containsExactly(nhanSu1);
    }

    @Test
    public void testFindAllCheckFalse() {

        NhanSu nhanSu1 = new NhanSu();
        nhanSu1.setHoTen("Thuong");
        nhanSu1.setSoDienThoai("0123456789");
        nhanSu1.setUsername("Thuong@gmail.com");
        nhanSu1.setPassword("1234");
        nhanSu1.setRole("admin");
        nhanSu1.setCheckUser(true);
        nhanSuRepo.save(nhanSu1);
        NhanSu nhanSu2 = new NhanSu();
        nhanSu2.setHoTen("ThuongDuy");
        nhanSu2.setSoDienThoai("0123457789");
        nhanSu2.setUsername("DuyThuong@gmail.com");
        nhanSu2.setPassword("12345");
        nhanSu2.setRole("admin");
        nhanSu2.setCheckUser(false);
        nhanSuRepo.save(nhanSu2);
        List<NhanSu> result = nhanSuRepo.findAllCheckFalse();
        assertThat(result).containsExactly(nhanSu2);
    }

    @Test
    public void testSearchPro() {
        NhanSu nhanSu1 = new NhanSu();
        nhanSu1.setHoTen("Thuong");
        nhanSu1.setSoDienThoai("0123456789");
        nhanSu1.setUsername("Thuong@gmail.com");
        nhanSu1.setPassword("1234");
        nhanSu1.setRole("admin");
        nhanSu1.setCheckUser(true);
        nhanSuRepo.save(nhanSu1);
        NhanSu nhanSu2 = new NhanSu();
        nhanSu2.setHoTen("ThuongDuy");
        nhanSu2.setSoDienThoai("0123457789");
        nhanSu2.setUsername("DuyThuong@gmail.com");
        nhanSu2.setPassword("12345");
        nhanSu2.setRole("admin");
        nhanSu2.setCheckUser(false);
        nhanSuRepo.save(nhanSu2);
        List<NhanSu> result = nhanSuRepo.searchPro("Duy");
        assertThat(result).containsExactly(nhanSu2);
    }

    @Test
    public void testFindByUsername() {

        NhanSu nhanSu1 = new NhanSu();
        nhanSu1.setHoTen("Thuong");
        nhanSu1.setSoDienThoai("0123456789");
        nhanSu1.setUsername("Thuong@gmail.com");
        nhanSu1.setPassword("1234");
        nhanSu1.setRole("admin");
        nhanSu1.setCheckUser(true);
        nhanSuRepo.save(nhanSu1);
        NhanSu nhanSu2 = new NhanSu();
        nhanSu2.setHoTen("ThuongDuy");
        nhanSu2.setSoDienThoai("0123457789");
        nhanSu2.setUsername("DuyThuong@gmail.com");
        nhanSu2.setPassword("12345");
        nhanSu2.setRole("admin");
        nhanSu2.setCheckUser(false);
        nhanSuRepo.save(nhanSu2);
        NhanSu result = nhanSuRepo.findByUsername("Thuong@gmail.com");

        assertThat(result).isEqualTo(nhanSu1);
    }
}
