package com.example.libruaryoop;

import com.example.libruaryoop.Model.Sach;
import com.example.libruaryoop.Repository.SachRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class SachRepoTest {
    @Autowired
    private SachRepo sachRepo;
    @Test
    public void testFindAllCheckTrue() {
        Sach sach1 = new Sach();
        sach1.setTenSach("Toan");
        sach1.setSoLuongCon(100);
        sach1.setNXB("Thuong");
        sach1.setTacGia("Thuong");
        sach1.setDaMuon(100);
        sach1.setNamXB(2000);
        sach1.setCheckSach(true);
        sachRepo.save(sach1);
        Sach sach2 = new Sach();
        sach2.setTenSach("Toan");
        sach2.setSoLuongCon(100);
        sach2.setNXB("Thuong");
        sach2.setTacGia("Thuong");
        sach2.setDaMuon(100);
        sach2.setNamXB(2000);
        sach2.setCheckSach(false);
        sachRepo.save(sach2);
        List<Sach> result = sachRepo.findAllCheckTrue();
        assertThat(result).containsExactly(sach1);
    }
    @Test
    public void testFindAllCheckFalse() {
        Sach sach1 = new Sach();
        sach1.setTenSach("Toan");
        sach1.setSoLuongCon(100);
        sach1.setNXB("Thuong");
        sach1.setTacGia("Thuong");
        sach1.setDaMuon(100);
        sach1.setNamXB(2000);
        sach1.setCheckSach(true);
        sachRepo.save(sach1);
        Sach sach2 = new Sach();
        sach2.setTenSach("Toan NC");
        sach2.setSoLuongCon(100);
        sach2.setNXB("Thuong Duy");
        sach2.setTacGia("Thuong");
        sach2.setDaMuon(100);
        sach2.setNamXB(2000);
        sach2.setCheckSach(false);
        sachRepo.save(sach2);
        List<Sach> result = sachRepo.findAllCheckTrue();
        assertThat(result).containsExactly(sach2);
    }
    @Test
    public void testFindAll() {
        Sach sach1 = new Sach();
        sach1.setTenSach("Toan");
        sach1.setSoLuongCon(100);
        sach1.setNXB("Thuong");
        sach1.setTacGia("Thuong");
        sach1.setDaMuon(100);
        sach1.setNamXB(2000);
        sach1.setCheckSach(true);
        sachRepo.save(sach1);
        Sach sach2 = new Sach();
        sach2.setTenSach("Toan NC");
        sach2.setSoLuongCon(100);
        sach2.setNXB("Thuong Duy");
        sach2.setTacGia("Thuong");
        sach2.setDaMuon(100);
        sach2.setNamXB(2000);
        sach2.setCheckSach(false);
        sachRepo.save(sach2);
        List<Sach> result = sachRepo.findAllCheckTrue();
        assertThat(result).containsExactly(sach1,sach2);
    }
    @Test
    public void testFindByName() {
        Sach sach1 = new Sach();
        sach1.setTenSach("Toan");
        sach1.setSoLuongCon(100);
        sach1.setNXB("Thuong");
        sach1.setTacGia("Thuong");
        sach1.setDaMuon(100);
        sach1.setNamXB(2000);
        sach1.setCheckSach(true);
        sachRepo.save(sach1);
        Sach sach2 = new Sach();
        sach2.setTenSach("Toan NC");
        sach2.setSoLuongCon(100);
        sach2.setNXB("Thuong Duy");
        sach2.setTacGia("Thuong");
        sach2.setDaMuon(100);
        sach2.setNamXB(2000);
        sach2.setCheckSach(false);
        sachRepo.save(sach2);
        Sach result = sachRepo.findByName("Toan");
        assertThat(result).isEqualTo(sach1);
    }
    @Test
    public void testFindById() {
        Sach sach1 = new Sach();
        sach1.setTenSach("Toan");
        sach1.setSoLuongCon(100);
        sach1.setNXB("Thuong");
        sach1.setTacGia("Thuong");
        sach1.setDaMuon(100);
        sach1.setNamXB(2000);
        sach1.setCheckSach(true);
        sachRepo.save(sach1);
        sach1.setMaSach(100L);
        Sach sach2 = new Sach();
        sach2.setTenSach("Toan NC");
        sach2.setSoLuongCon(100);
        sach2.setNXB("Thuong Duy");
        sach2.setTacGia("Thuong");
        sach2.setDaMuon(100);
        sach2.setNamXB(2000);
        sach2.setCheckSach(false);
        sachRepo.save(sach2);
        sach2.setMaSach(150L);
        Sach result = sachRepo.findSachById(100L);
        assertThat(result).isEqualTo(sach1);
    }
    @Test
    public void testFindByDaMuon() {
        Sach sach1 = new Sach();
        sach1.setTenSach("Toan");
        sach1.setSoLuongCon(100);
        sach1.setNXB("Thuong");
        sach1.setTacGia("Thuong");
        sach1.setDaMuon(100);
        sach1.setNamXB(2000);
        sach1.setCheckSach(true);
        sachRepo.save(sach1);
        sach1.setMaSach(100L);
        Sach sach2 = new Sach();
        sach2.setTenSach("Toan NC");
        sach2.setSoLuongCon(100);
        sach2.setNXB("Thuong Duy");
        sach2.setTacGia("Thuong");
        sach2.setDaMuon(0);
        sach2.setNamXB(2000);
        sach2.setCheckSach(false);
        sachRepo.save(sach2);
        sach2.setMaSach(150L);
        Sach result = sachRepo.findsoLuongById(100L);
        assertThat(result).isEqualTo(100);
    }
    @Test
    public void TestfindSachBySoLuong() {
        Sach sach1 = new Sach();
        sach1.setTenSach("Toan");
        sach1.setSoLuongCon(100);
        sach1.setNXB("Thuong");
        sach1.setTacGia("Thuong");
        sach1.setDaMuon(100);
        sach1.setNamXB(2000);
        sach1.setCheckSach(true);
        sachRepo.save(sach1);
        sach1.setMaSach(100L);
        Sach sach2 = new Sach();
        sach2.setTenSach("Toan NC");
        sach2.setSoLuongCon(100);
        sach2.setNXB("Thuong Duy");
        sach2.setTacGia("Thuong");
        sach2.setDaMuon(0);
        sach2.setNamXB(2000);
        sach2.setCheckSach(false);
        sachRepo.save(sach2);
        sach2.setMaSach(150L);
        List<Sach> result = sachRepo.findSachBySoLuong(10L);
        assertThat(result).containsExactly(sach2);
    }
}
