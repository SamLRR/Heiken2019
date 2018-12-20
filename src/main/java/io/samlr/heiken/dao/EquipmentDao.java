package io.samlr.heiken.dao;

import io.samlr.heiken.entity.Equipment;

import java.util.List;

public interface EquipmentDao extends BasicDao<Equipment> {

    Equipment getEquipmentByName(String name);

    List<Equipment> getEquipmentById(String id);
}
