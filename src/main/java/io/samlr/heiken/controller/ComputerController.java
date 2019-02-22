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
import java.util.ArrayList;
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

    @RequestMapping(value = "findByDescr", method = RequestMethod.POST)
    public String filter1(@RequestParam String findByDescr, ModelMap model) {
        List<Computer> computers;

        if (findByDescr != null && !findByDescr.isEmpty()) {
            computers = computerService.getComputerByIp(findByDescr);
        } else {
            computers = computerService.getAllComputers();
        }
        model.addAttribute("computer", computers);
        return "all_computers";
    }

    @RequestMapping(value = "findBySerial", method = RequestMethod.POST)
    public String filter2(@RequestParam String serial, ModelMap model) {
        List<Equipment> equipments = equipmentService.getEquipmentsBySerial(serial);
        List<Computer> computers = new ArrayList<>();

        if (serial != null && !serial.isEmpty()) {
            for (Equipment equipment : equipments) {
                computers.add(equipment.getComputer());
            }
        } else {
            computers = computerService.getAllComputers();
        }
        model.addAttribute("computer", computers);
        return "all_computers";
    }

    @RequestMapping(value = "findByBarCode", method = RequestMethod.POST)
    public String filter3(@RequestParam String barCode, ModelMap model) {
        List<Equipment> equipments = equipmentService.getEquipmentsByBarCode(barCode);
        List<Computer> computers = new ArrayList<>();

        if (barCode != null && !barCode.isEmpty()) {
            for (Equipment equipment : equipments) {
                computers.add(equipment.getComputer());
            }
        } else {
            computers = computerService.getAllComputers();
        }
        model.addAttribute("computer", computers);
        return "all_computers";
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

        model.addAttribute("success", "Компьютер " + computer.getArmName() + " успешно зарегистрирован!");
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

        model.addAttribute("success", "Компьютер " + computer.getArmName() + " успешно обновлён!");
        return "registrationSuccess";
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Computer updateEvent(@RequestBody Computer computer) {
        return computerService.updateComputer(computer);
    }
}
