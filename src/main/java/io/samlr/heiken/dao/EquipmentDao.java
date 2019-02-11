package io.samlr.heiken.dao;

import io.samlr.heiken.entity.Equipment;

import java.util.List;

public interface EquipmentDao extends BasicDao<Equipment> {

    Equipment getEquipmentByName(String name);

    List<Equipment> getEquipmentById(String id);

    List<Equipment> getAllEquipmentsOfComputer(Long id);

    List<Equipment> getEquipmentsBySerial(String serial);

    List<Equipment> getEquipmentsByBarCode(String barCode);
}
