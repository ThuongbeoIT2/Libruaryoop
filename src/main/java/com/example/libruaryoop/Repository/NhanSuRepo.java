package com.example.libruaryoop.Repository;

import com.example.libruaryoop.Model.NhanSu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhanSuRepo extends JpaRepository<NhanSu,Long> {
    /// bit 1 = true  đưa ra danh sách hoạt động trong ngày
    @Query("select u from nhan_su u where u.checkUser=true order by u.user_id asc ")
    List<NhanSu> findAllCheckTrue();
    // bit 0 = false đưa ra danh sách nhân viên dự phòng chưa phân công
    @Query("select u from nhan_su u where u.checkUser=false order by u.user_id asc ")
    List<NhanSu> findAllCheckFalse();
    // Tìm kiếm nhanh theo khóa
    @Query("select u from nhan_su u where u.soDienThoai like %:key% or u.hoTen like %:key% or u.Username like %:key% order by u.user_id desc ")
    List<NhanSu> searchPro(String key);
    // Tìm kiếm theo username. Dùng trong truy vấn role
    @Query("SELECT u FROM nhan_su u WHERE u.Username = :Username and u.checkUser=true")
    NhanSu findByUsername(@Param("Username") String Username);
    // Tìm kiếm xem nhân sự đã có trong mục nhân viên chưa

}
