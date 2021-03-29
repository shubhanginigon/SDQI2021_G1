package com.sdqi2021.AQMS.controller;

import com.sdqi2021.AQMS.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

    @ModelAttribute("module")
    public String module() {
        return "dashboard";
    }

    @GetMapping("/admin")
    public String showAdminIndex(Model model) {
        model.addAttribute("title", "Admin Dashboard");
        return "admin_index";
    }

    @GetMapping("/admin-login")
    public String showAdminLoginForm(Model model) {
        model.addAttribute("title", "Admin Login");
        model.addAttribute("user", new User());
        return "admin_login";
    }

    @PostMapping("/admin-login")
    public String performAdminLogin(@ModelAttribute User user, Model model) {
        LOGGER.info("{} LOGGED IN !", user.getUsername());
        return "redirect:/admin";
    }

}
