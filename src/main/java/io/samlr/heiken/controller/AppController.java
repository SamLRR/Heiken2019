package io.samlr.heiken.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

    @RequestMapping("/")
    public String getHelloPage() {

        return "all_computers";
    }

    @RequestMapping("/adminpage")
    public String getAdminPage() {

        return "adminPage";
    }
}
