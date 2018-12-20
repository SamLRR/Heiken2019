package io.samlr.heiken.service;

import io.samlr.heiken.entity.Equipment;

import java.util.List;

public interface EquipmentService {

    Equipment addEquipment(Equipment equipment);

    Equipment getEquipmentById(Long ip);

    List<Equipment> getAllEquipments();

    Equipment getEquipmentByName(String name);

    Equipment updateEquipment(Equipment equipment);
}
