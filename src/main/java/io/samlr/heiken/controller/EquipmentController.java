package io.samlr.heiken.controller;

import io.samlr.heiken.entity.Equipment;
import io.samlr.heiken.service.ComputerService;
import io.samlr.heiken.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/equipment")
public class EquipmentController {
    private final EquipmentService equipmentService;
    private final ComputerService computerService;

    @Autowired
    public EquipmentController(EquipmentService equipmentService, ComputerService computerService) {
        this.equipmentService = equipmentService;
        this.computerService = computerService;
    }

    @RequestMapping(value = "/{id}/add", method = RequestMethod.GET)
    public String newEquipment(ModelMap model) {
        Equipment equipment = new Equipment();
        model.addAttribute("equipment", equipment);
        model.addAttribute("edit", false);
        return "registrationEquipment";
    }

    @RequestMapping(value = {"/{id}/add"}, method = RequestMethod.POST)
    public String saveEquipment(@Valid Equipment equipment, BindingResult result,
                                ModelMap model, @PathVariable String id) {
        if (result.hasErrors()) {
            return "registrationEquipment";
        }

        equipment.setComputer(computerService.getComputerById(Long.valueOf(id)));
        equipmentService.addEquipment(equipment);

        model.addAttribute("success", "Equipment " + equipment.getDescription() + " registered successfully");
        return "registrationSuccess";
    }


    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Equipment getEquipmentById(@PathVariable(value = "id") String id) {
        return equipmentService.getEquipmentById(Long.parseLong(id));
    }

    @RequestMapping(value = "/get/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Equipment> getAllEquipments() {
        return equipmentService.getAllEquipments();
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Equipment updateEvent(@RequestBody Equipment equipment) {
        return equipmentService.updateEquipment(equipment);
    }

    @RequestMapping(value = "/all_equipments", method = RequestMethod.GET)
    public String getAllComputers(Model model) {
        model.addAttribute("equipment", equipmentService.getAllEquipments());

        return "all_equipments";
    }

    @RequestMapping(value = {"/edit-equipment-{id}"}, method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public String editEquipment(@PathVariable String id, ModelMap model) {
        Equipment equipment = equipmentService.getEquipmentById(Long.valueOf(id));
        model.addAttribute("equipment", equipment);
        model.addAttribute("edit", true);
        return "registrationEquipment";
    }

    /**
     * This method will be called on form submission, handling POST request for
     * updating equipment in database. It also validates the equipment input
     */
    @RequestMapping(value = {"/edit-equipment-{id}"}, method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public String updateEquipment(@Valid Equipment equipment, BindingResult result, ModelMap model) {

        if (result.hasErrors()) {
            return "registrationEquipment";
        }

        equipmentService.updateEquipment(equipment);

        model.addAttribute("success", "Equipment " + equipment.getDescription() + " updated successfully");
        return "registrationSuccess";
    }

    @RequestMapping(value = "filter", method =RequestMethod.POST)
    public String filter(@RequestParam String filter, ModelMap model) {
        List<Equipment> equipments;

        if (filter != null && !filter.isEmpty()) {
            equipments = equipmentService.getEquipmentsBySerial(filter);
        } else {
            equipments = equipmentService.getAllEquipments();
        }
        model.addAttribute("equipment", equipments);
        return "all_equipments";
    }

}
