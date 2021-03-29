package com.sdqi2021.AQMS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {

    @ModelAttribute("module")
    public String module() {
        return "dashboard";
    }

    @GetMapping
    public String showAdminIndex() {
        return "admin_index";
    }

}
