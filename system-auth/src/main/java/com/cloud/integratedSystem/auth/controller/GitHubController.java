package com.cloud.integratedSystem.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class GitHubController {
    @GetMapping("/github")
    public String github(Principal principal) {
        return "hello, " + principal.getName();
    }
}
