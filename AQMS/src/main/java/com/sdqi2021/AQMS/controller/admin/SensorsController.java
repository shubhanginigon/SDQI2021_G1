package com.sdqi2021.AQMS.controller.admin;

import com.sdqi2021.AQMS.service.SensorSettingsService;
import com.sdqi2021.AQMS.service.StationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/sensors")
public class SensorsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SensorsController.class);

    @Autowired
    StationService stationService;

    @Autowired
    SensorSettingsService sensorSettingsService;

    @ModelAttribute("module")
    public String module() {
        return "sidebar_sensors";
    }

    @GetMapping({"/", ""})
    public String showSensorsIndex(Model model) {

//        model.addAttribute("stations", stationService.findAllStations());
//        model.addAttribute("settings", stationService.getSettings());

        model.addAttribute("title", "Sensors Management");
        model.addAttribute("results", sensorSettingsService.queryAll());
        return "sensors_index";
    }

}
