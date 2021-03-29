package com.sdqi2021.AQMS.controller;

import com.sdqi2021.AQMS.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @ModelAttribute("module")
    public String module() {
        return "dashboard";
    }

    @GetMapping("/")
    public String showPublicIndex() {
        return "index";
    }

    @GetMapping("/admin-login")
    public String showAdminLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "admin_login";
    }

    @PostMapping("/admin-login")
    public String performAdminLogin(@ModelAttribute User user, Model model) {
        System.out.println(user);
        return "redirect:/admin";
    }
}
