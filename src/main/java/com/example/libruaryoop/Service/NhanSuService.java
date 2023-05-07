package com.example.libruaryoop.Service;




import com.example.libruaryoop.Model.NhanSu;
import com.example.libruaryoop.Repository.NhanSuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhanSuService {
    @Autowired
    private NhanSuRepo nhanSuRepo;

    public List<NhanSu> findAllCheckTrue() {
        return nhanSuRepo.findAllCheckTrue();
    }
    public List<NhanSu> findAllCheckFalse() {
        return nhanSuRepo.findAllCheckFalse();
    }
    public List<NhanSu> searchPro(String key) {
        return nhanSuRepo.searchPro(key);
    }
// Ẩn nhân sự vào danh sách dự phong
    public void deleteById(Long user_id) {
        NhanSu fromDB = nhanSuRepo.findById(user_id).orElse(null);
        if (fromDB == null) {
            return;

        }
        fromDB.setCheckUser(false);
        nhanSuRepo.save(fromDB);

    }
    // Đưa nhân sự lên làm việc. Sắp ca theo ngày.
    public void changeById(Long user_id) {
        NhanSu fromDB = nhanSuRepo.findById(user_id).orElse(null);
        if (fromDB == null) {
            return;

        }
        fromDB.setCheckUser(true);
        nhanSuRepo.save(fromDB);

    }

    public void addUser(NhanSu user) {
        user.setCheckUser(false);
        nhanSuRepo.save(user);
    }

//
    public NhanSu updateUser(NhanSu user){
        NhanSu existing = nhanSuRepo.findById(user.getUser_id()).orElse(null);
        if(existing!=null){
            existing.setHoTen(user.getHoTen());
            existing.setSoDienThoai(user.getSoDienThoai());
            existing.setUsername(user.getUsername());
            existing.setPassword(user.getPassword());
            existing.setRole(user.getRole());
            existing.setCheckUser(true);
            System.out.println(existing);
            return nhanSuRepo.save(existing);
        }
        return null;
    }
    public NhanSu findUserById(Long user_id){
        return nhanSuRepo.findById(user_id).orElse(null);
    }
    public NhanSu findUserByUsername(String Username){
        return nhanSuRepo.findByUsername(Username);
    }
}

