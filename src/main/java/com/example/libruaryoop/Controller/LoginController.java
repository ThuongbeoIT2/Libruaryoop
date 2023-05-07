package com.example.libruaryoop.Controller;

import com.example.libruaryoop.Model.NhanSu;
import com.example.libruaryoop.Service.NhanSuService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    private NhanSuService userService;
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        // Hiển thị trang đăng nhập
        model.addAttribute("user", new NhanSu());
        return "home/login";
    }
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpServletRequest request) {
        // Xử lý đăng nhập và kiểm tra thông tin đăng nhập

        // Nếu thông tin đăng nhập hợp lệ, lưu thông tin người dùng vào session
        HttpSession session = request.getSession();
        session.setAttribute("username", username);
        session.setAttribute("password",password);
        return "redirect:/home";
    }
    @GetMapping("/log-out")
    public String Logout( HttpSession session) {
        // Hiển thị trang đăng nhập

        session.removeAttribute("username");
        session.removeAttribute("password");
        System.out.println("clear session");
//La remove session tài khoản.
        return "redirect:/login";
    }
}
