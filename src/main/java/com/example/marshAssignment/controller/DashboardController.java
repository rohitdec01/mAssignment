package com.example.marshAssignment.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
//@CrossOrigin()
public class DashboardController {

    @GetMapping("/dashboardUserDetail")
    public String dashboardsUserDetail(@AuthenticationPrincipal Authentication authentication) {
        return "user's dashboards";
    }
}
