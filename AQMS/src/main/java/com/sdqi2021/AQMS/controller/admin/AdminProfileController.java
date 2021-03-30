package com.sdqi2021.AQMS.controller.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/profile")
public class AdminProfileController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminProfileController.class);

    @ModelAttribute("module")
    public String module() {
        return "sidebar_profile";
    }

    @GetMapping({"/", ""})
    public String showProfileIndex(Model model) {
        model.addAttribute("title", "Profile Management");
        return "profile_index";
    }
}
