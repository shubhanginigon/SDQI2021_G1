package com.sdqi2021.AQMS.controller.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/settings")
public class SettingsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SettingsController.class);

    @ModelAttribute("module")
    public String module() {
        return "sidebar_settings";
    }

    @GetMapping({"/", ""})
    public String showSettingsIndex(Model model) {
        model.addAttribute("title", "Web App Settings");
        return "settings_index";
    }
}
