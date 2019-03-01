package io.samlr.heiken.service;

import io.samlr.heiken.entity.Computer;
import io.samlr.heiken.entity.Equipment;

import java.util.List;

public interface EquipmentService {

    Equipment addEquipment(Equipment equipment);

    Equipment getEquipmentById(Long id);

    List<Equipment> getAllEquipments();

    Equipment getEquipmentByName(String name);

    Equipment updateEquipment(Equipment equipment);

    List<Equipment> getAllEquipmentsByComputerId(Long id);

    List<Equipment> getEquipmentsBySerial(String filter);

    List<Equipment> getEquipmentsByBarCode(String barCode);

    List<Equipment> getAllEquipmentsFree();
}
