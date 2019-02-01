package io.samlr.heiken.controller;

import io.samlr.heiken.entity.Computer;
import io.samlr.heiken.entity.Equipment;
import io.samlr.heiken.entity.Node;
import io.samlr.heiken.service.ComputerService;
import io.samlr.heiken.service.EquipmentService;
import io.samlr.heiken.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/computer")
public class ComputerController {
    private final ComputerService computerService;
    private final EquipmentService equipmentService;
    private final NodeService nodeService;

    @Autowired
    public ComputerController(ComputerService computerService, EquipmentService equipmentService, NodeService nodeService) {
        this.computerService = computerService;
        this.equipmentService = equipmentService;
        this.nodeService = nodeService;
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Computer getComputerById(@PathVariable(value = "id") String id) {
        return computerService.getComputerById(Long.parseLong(id));
    }

    @RequestMapping(value = "/get/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Computer> getAllComputers() {
        return computerService.getAllComputers();
    }

    @RequestMapping("/all_computers")
    public String getAllComputers(Model model) {
        model.addAttribute("computer", computerService.getAllComputers());

        return "all_computers";
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

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String newComputer(ModelMap model) {
        Computer computer = new Computer();
        model.addAttribute("computer", computer);
        model.addAttribute("edit", false);
        return "registrationComputer";
    }

    @RequestMapping(value = {"/add"}, method = RequestMethod.POST)
    public String saveComputer(@Valid Computer computer, BindingResult result,
                               ModelMap model) {
        if (result.hasErrors()) {
            return "registrationComputer";
        }
        computerService.addComputer(computer);

        model.addAttribute("success", "Computer " + computer.getArmName() + " registered successfully");
        return "registrationSuccess";
    }

    @RequestMapping(value = {"/edit-computer-{id}"}, method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public String editComputer(@PathVariable String id, ModelMap model) {
        Computer computer = computerService.getComputerById(Long.parseLong(id));
        List<Equipment> equipments = equipmentService.getAllEquipmentsByComputerId(computer.getId());
        model.addAttribute("computer", computer);
        List<Node> nodes = nodeService.getAllNodes();
        model.addAttribute("nodes", nodes);
        model.addAttribute("equipments", equipments);
        model.addAttribute("edit", true);
        return "registrationComputer";
    }

    /**
     * This method will be called on form submission, handling POST request for
     * updating computer in database. It also validates the computer input
     */
    @RequestMapping(value = {"/edit-computer-{id}"}, method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public String updateComputer(@Valid Computer computer, BindingResult result, ModelMap model) {

        if (result.hasErrors()) {
            return "registrationComputer";
        }

        computerService.updateComputer(computer);

        model.addAttribute("success", "Computer " + computer.getArmName() + " updated successfully");
        return "registrationSuccess";
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Computer updateEvent(@RequestBody Computer computer) {
        return computerService.updateComputer(computer);
    }
}
