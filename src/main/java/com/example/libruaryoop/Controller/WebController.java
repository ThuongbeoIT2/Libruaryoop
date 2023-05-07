package com.example.libruaryoop.Controller;


import com.example.libruaryoop.Model.NhanSu;
import com.example.libruaryoop.Service.NhanSuService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class WebController {
    @Autowired
    private NhanSuService nhanSuService;

    @GetMapping("/home")
    public String home(HttpSession session, Model model) {
        // Kiểm tra xem người dùng đã đăng nhập chưa
        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");
        NhanSu nhanSu= nhanSuService.findUserByUsername(username);
        System.out.println(nhanSu);
        System.out.println(username);
        System.out.println(password);
       if(nhanSu!=null){
           if(nhanSu.getPassword().equals(password)){
               if(nhanSu.getRole().equals("admin")){
                   return "home/home_admin";
               } else  if(nhanSu.getRole().equals("user")){
                   return "home/home_user";
               }
               // Lấy thông tin người dùng từ cơ sở dữ liệu và đưa vào model để hiển thị trên view
               model.addAttribute("useronl", nhanSu);

           }
       }
       session.removeAttribute("username");
       session.removeAttribute("password");
        return "home/welcom";
    }
}










