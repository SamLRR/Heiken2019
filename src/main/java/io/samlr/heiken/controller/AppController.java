package io.samlr.heiken.controller;

import io.samlr.heiken.util.SecurityUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
    final private SecurityUtil securityUtil;

    public AppController(SecurityUtil securityUtil) {
        this.securityUtil = securityUtil;
    }

    @RequestMapping("/")
    public ModelAndView getHelloPage() {
        ModelAndView model = new ModelAndView();
        if ("anonymousUser".equals(securityUtil.getAuthorizedUser())) {
            model.addObject("user", "Гость");
        } else {
            model.addObject("user", securityUtil.getAuthorizedUser());
        }
        model.setViewName("helloPage");
        return model;
    }

    @RequestMapping("/adminpage")
    public String getAdminPage() {

        return "adminPage";
    }
}
