package com.sdqi2021.AQMS.controller;

import com.sdqi2021.AQMS.service.RestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PublicDashboardController {

    @Autowired
    RestService restService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PublicDashboardController.class);

    // @ModelAttribute("module")
    // public String module() {
    // return "navbar_dashboard";
    // }

    @GetMapping("/")
    public String showPublicIndex(Model model) {
        model.addAttribute("title", "Public Dashboard");
        model.addAttribute("module", "navbar_dashboard");


        List<List<String>> sensorTypes = restService.getTotalSensorTypes();
        String totalSensorTypes = sensorTypes.get(0).get(0);
        model.addAttribute("totalSensorTypes", totalSensorTypes);

        List<List<String>> stationTypes = restService.getTotalStationTypes();
        String totalStationTypes = stationTypes.get(0).get(0);
        model.addAttribute("totalStationTypes", totalStationTypes);

        List<List<String>> totalRows = restService.getTotalRowsOfData();
        String totalRowsStr = totalRows.get(0).get(0);
        model.addAttribute("totalRows", totalRowsStr);

        return "index";
    }

    @GetMapping("/features")
    public String showFeaturesIndex(Model model) {
        model.addAttribute("title", "Features");
        model.addAttribute("module", "navbar_features");
        return "features";
    }

    @GetMapping("/our-team")
    public String showOurTeamIndex(Model model) {
        model.addAttribute("title", "Our Team");
        model.addAttribute("module", "navbar_our_team");
        return "our_team";
    }

    @GetMapping("/about")
    public String showAboutIndex(Model model) {
        model.addAttribute("title", "About");
        model.addAttribute("module", "navbar_about");
        return "about";
    }

}
