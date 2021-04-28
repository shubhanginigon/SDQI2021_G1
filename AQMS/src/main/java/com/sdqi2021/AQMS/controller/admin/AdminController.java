package com.sdqi2021.AQMS.controller.admin;

import com.sdqi2021.AQMS.model.SensorSettings;
import com.sdqi2021.AQMS.model.User;
import com.sdqi2021.AQMS.service.JobSchedulerService;
import com.sdqi2021.AQMS.service.SensorSettingsService;
import com.sdqi2021.AQMS.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;


@Controller
@RequestMapping("admin")
public class AdminController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    UserService userService;

    @Autowired
    JobSchedulerService jobSchedulerService;

    @Autowired
    SensorSettingsService sensorSettingsService;

    @ModelAttribute("module")
    public String module() {
        return "sidebar_dashboard";
    }

    @GetMapping({"/", ""})
    public String showAdminIndex(Model model) {
        model.addAttribute("title", "Admin Dashboard");

        // Start Station service on admin login based on settings
        startStopStationServers();

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

    @Transactional
    @PostMapping("startServer")
    public String startServer() {
        LOGGER.info("Server Started and Running...");
        sensorSettingsService.getSettings().setServerRunning(true);
        startStopStationServers();
        return "redirect:/admin/sensors";
    }

    @Transactional
    @PostMapping("stopServer")
    public String stopServer() {
        LOGGER.info("Server Stopped...");
        sensorSettingsService.getSettings().setServerRunning(false);
        return "redirect:/admin/sensors";
    }

    private void startStopStationServers() {
        // Start Station service on admin login based on settings
        if (sensorSettingsService.getSettings().isServerRunning()) {
            jobSchedulerService.startRetrievingStations();
        }
    }

}
