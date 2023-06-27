package com.example.libruaryoop.Controller;


import com.example.libruaryoop.Model.NhanSu;
import com.example.libruaryoop.Service.NhanSuService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class NhanSuController {
    @Autowired
    private NhanSuService nhanSuService;
    @GetMapping("/list-nhansu")
    public String index(Model model, HttpSession session) {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }
        System.out.println(username);
        model.addAttribute("listTrue", nhanSuService.findAllCheckTrue());
        return "admin/nhansu/list_nhansu";
    }
    @GetMapping("/luutru-nhansu")
    public String Luutru(Model model,HttpSession session) {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }
        System.out.println(username);
        model.addAttribute("listFalse", nhanSuService.findAllCheckFalse());
        return "admin/nhansu/luutru_nhansu";
    }

    @GetMapping("/add-nhansu")
    public String addUser(Model model,HttpSession session) {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }
        System.out.println(username);
        model.addAttribute("user", new NhanSu());

        return "admin/nhansu/add_nhansu";
    }
    @PostMapping("/add-nhansu")
    public String addUser(@ModelAttribute("user") NhanSu user,HttpSession session,Model model) {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }
        NhanSu nhanSu=nhanSuService.findUserByUsername(user.getUsername());
        if(nhanSu!=null){
            String message="Tai khoan da ton tai. Vui long tao lai";
            model.addAttribute("message",message);
            return "admin/nhansu/add_nhansu";
        }
        user.setHoTen(user.getHoTen());
        user.setSoDienThoai(user.getSoDienThoai());
        user.setUsername(user.getUsername());
        user.setPassword(user.getPassword());
        user.setRole(user.getRole());
        System.out.println(user);
        nhanSuService.addUser(user);
        return "redirect:/list-nhansu";

    }

//

    @GetMapping("/edit-nhansu/{user_id}")
    public String editSupplier(Model model, @PathVariable Long user_id,HttpSession session) {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }
        NhanSu user = nhanSuService.findUserById(user_id);
        System.out.println(user);
        model.addAttribute("user", user);
        return "admin/nhansu/edit_nhansu";
    }

    @PostMapping("/update-nhansu")
    public String editSupplier(@ModelAttribute("user") NhanSu user,HttpSession session) {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }
        nhanSuService.updateUser(user);
        System.out.println(user);
        return "redirect:/list-nhansu";
    }

    @GetMapping("/delete-nhansu/{user_id}")
    public String deleteUserById(@PathVariable("user_id") Long user_id,HttpSession session) {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }
        nhanSuService.deleteById(user_id);
        return "redirect:/list-nhansu";
    }
    @GetMapping("/change-nhansu/{user_id}")
    public String changeUserById(@PathVariable("user_id") Long user_id,HttpSession session) {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }
        nhanSuService.changeById(user_id);
        return "redirect:/list-nhansu";
    }
    @GetMapping("/list-search_nhansu/{key}")
    public String index(Model model,@PathVariable("key") String key,HttpSession session) {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }
        model.addAttribute("listsearch", nhanSuService.searchPro(key));
        return "admin/nhansu/list_nhansu";
    }
}

