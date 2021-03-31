package com.sdqi2021.AQMS.controller.admin;

import com.sdqi2021.AQMS.model.User;
import com.sdqi2021.AQMS.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("admin")
public class AdminController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    UserService userService;

    @ModelAttribute("module")
    public String module() {
        return "sidebar_dashboard";
    }

    @GetMapping({"/", ""})
    public String showAdminIndex(Model model) {
        //User user = userService.findByUsername(principal.getName());
        model.addAttribute("title", "Admin Dashboard");
        //model.addAttribute("user", user);
        return "admin_index";
    }

    @GetMapping("login")
    public String showAdminLoginForm(Model model) {
        model.addAttribute("title", "Admin Login");
        model.addAttribute("user", new User());
        return "admin_login";
    }

    @PostMapping("login")
    public String performAdminLogin(@ModelAttribute User user, Model model) {
        LOGGER.info("{} LOGGED IN !", user.getUsername());
        return "redirect:/admin";
    }

}
