package io.samlr.heiken.controller;

import io.samlr.heiken.entity.Equipment;
import io.samlr.heiken.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/equipment")
public class EquipmentController {
    private final EquipmentService equipmentService;

    @Autowired
    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Equipment addEquipment(@RequestBody Equipment equipment) {
        return equipmentService.addEquipment(equipment);
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
}
