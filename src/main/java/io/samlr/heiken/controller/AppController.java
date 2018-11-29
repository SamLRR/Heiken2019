package io.samlr.heiken.controller;

import io.samlr.heiken.entity.Computer;
import io.samlr.heiken.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AppController {

    @Autowired
    ComputerService computerService;

    @RequestMapping("/")
    public String getHelloPage() {

        return "helloPage";
    }

    @RequestMapping("/adminpage")
    public String getAdminPage() {

        return "adminPage";
    }

    @RequestMapping("/all_computers")
    public String getAllComputers(Model model) {
        model.addAttribute("computer", computerService.getAllComputers());

        return "all_computers";
    }

    @RequestMapping(value = {"/edit-computer-{id}"}, method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public String editComputer(@PathVariable String id, ModelMap model) {
        Computer computer = computerService.getComputerById(Long.parseLong(id));
        model.addAttribute("computer", computer);
        model.addAttribute("edit", true);
        return "registration";
    }

    /**
     * This method will be called on form submission, handling POST request for
     * updating computer in database. It also validates the computer input
     */
    @RequestMapping(value = {"/edit-computer-{id}"}, method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public String updateComputer(@Valid Computer computer, BindingResult result, ModelMap model) {

        if (result.hasErrors()) {
            return "registration";
        }

        computerService.updateComputer(computer);

        model.addAttribute("success", "Computer " + computer.getArmName() + " updated successfully");
        return "registrationSuccess";
    }

    @PostMapping("filter")
    public String getComputerByIp(@RequestParam String ip, ModelMap model) {
        List<Computer> computers;

        if (ip != null && !ip.isEmpty()) {
            computers = computerService.getComputerByIp(ip);
        } else {
            computers = computerService.getAllComputers();
        }
        model.addAttribute("computers", computers);
        return "filter";
    }

    @RequestMapping(value = "/new_computer", method = RequestMethod.GET)
    public String newComputer(ModelMap model){
        Computer computer = new Computer();
        model.addAttribute("computer", computer);
        model.addAttribute("edit", false);
        return "registration";
    }

    @RequestMapping(value = { "/new_computer" }, method = RequestMethod.POST)
    public String saveUser(@Valid Computer computer, BindingResult result,
                           ModelMap model) {
        if (result.hasErrors()) {
            return "registration";
        }
        computerService.addComputer(computer);

        model.addAttribute("success", "Computer " + computer.getArmName() + " registered successfully");
        return "registrationSuccess";
    }
}
