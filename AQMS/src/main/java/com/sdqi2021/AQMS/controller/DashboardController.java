package com.sdqi2021.AQMS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class DashboardController {

    @ModelAttribute("module")
    public String module() {
        return "dashboard";
    }

    @GetMapping("/")
    public String showPublicIndex(Model model) {
        model.addAttribute("title", "Public Dashboard");
        return "index";
    }

}
