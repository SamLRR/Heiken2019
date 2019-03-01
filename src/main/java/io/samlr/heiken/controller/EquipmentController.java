package io.samlr.heiken.controller;

import io.samlr.heiken.entity.Computer;
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

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String newEquipment(ModelMap model){
        Equipment equipment = new Equipment();
        model.addAttribute("equipment", equipment);
        model.addAttribute("edit", false);
        return "registrationEquipment";
    }

    @RequestMapping(value = {"/add"}, method = RequestMethod.POST)
    public String saveEquipment(@Valid Equipment equipment, BindingResult result, ModelMap model){
        if (result.hasErrors()) {
            return "registrationEquipment";
        }
        equipmentService.addEquipment(equipment);

        model.addAttribute("success", "Оборудование " + equipment.getDescription() + " успешно зарегистрировано!");
        return "registrationSuccess";
    }

    @RequestMapping(value = "/{id}/add", method = RequestMethod.GET)
    public String newEquipmentForRealComputer(ModelMap model) {
        Equipment equipment = new Equipment();
        model.addAttribute("equipment", equipment);
        model.addAttribute("edit", false);
        return "registrationEquipment";
    }

    @RequestMapping(value = {"/{id}/add"}, method = RequestMethod.POST)
    public String saveEquipmentForRealComputer(@Valid Equipment equipment, BindingResult result,
                                ModelMap model, @PathVariable String id) {
        if (result.hasErrors()) {
            return "registrationEquipment";
        }

        Computer computer = computerService.getComputerById(Long.valueOf(id));
        equipment.setComputer(computer);
        equipment.setDescription(computer.getArmName());
        equipment.setWs_component(true);
        equipmentService.addEquipment(equipment);
        equipmentService.updateEquipment(equipment);

        model.addAttribute("success", "Устройство для " + equipment.getDescription() + " успешно зарегистрировано.");
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

    @RequestMapping(value = "/all_equipments_free", method = RequestMethod.GET)
    public String getAllComputersFree(Model model) {
        model.addAttribute("equipment", equipmentService.getAllEquipmentsFree());

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
        equipment.setWs_component(true);
        equipmentService.updateEquipment(equipment);

        model.addAttribute("success", "Устройство " + equipment.getDescription() + " успешно обновлено.");
        return "registrationSuccess";
    }

    @RequestMapping(value = "findBySerial", method = RequestMethod.POST)
    public String filter1(@RequestParam String serial, ModelMap model) {
        List<Equipment> equipments;

        if (serial != null && !serial.isEmpty()) {
            equipments = equipmentService.getEquipmentsBySerial(serial);
        } else {
            equipments = equipmentService.getAllEquipments();
        }
        model.addAttribute("equipment", equipments);
        return "all_equipments";
    }

    @RequestMapping(value = "findByBarCode", method = RequestMethod.POST)
    public String filter2(@RequestParam String barCode, ModelMap model) {
        List<Equipment> equipments;

        if (barCode != null && !barCode.isEmpty()) {
            equipments = equipmentService.getEquipmentsByBarCode(barCode);
        } else {
            equipments = equipmentService.getAllEquipments();
        }
        model.addAttribute("equipment", equipments);
        return "all_equipments";
    }

    @RequestMapping(value = "/remove_to_storage/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public String removeToStorage(@PathVariable String id/*, BindingResult result*/, ModelMap model) {
//        if (result.hasErrors()) {
//            return "registrationEquipment";
//        }
        Equipment equipment = equipmentService.getEquipmentById(Long.valueOf(id));
        equipment.setWs_component(false);
        equipmentService.updateEquipment(equipment);
        model.addAttribute("success", "Устройство " + equipment.getModel() + " успешно перемещено на склад.");
        return "registrationSuccess";
    }
}
