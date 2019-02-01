package io.samlr.heiken.service.impl;

import io.samlr.heiken.dao.EquipmentDao;
import io.samlr.heiken.entity.Equipment;
import io.samlr.heiken.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    EquipmentDao equipmentDao;

    @Override
    public Equipment addEquipment(Equipment equipment) {
        return equipmentDao.create(equipment);
    }

    @Override
    public Equipment getEquipmentById(Long id) {
        return equipmentDao.getById(id);
    }

    @Override
    public List<Equipment> getAllEquipments() {
        return equipmentDao.getList();
    }

    @Override
    public Equipment getEquipmentByName(String name) {
        return equipmentDao.getEquipmentByName(name);
    }

    @Override
    public Equipment updateEquipment(Equipment equipment) {
        return equipmentDao.update(equipment);
    }

    @Override
    public List<Equipment> getAllEquipmentsByComputerId(Long id) {
        return equipmentDao.getAllEquipmentsOfComputer(id);
    }

    @Override
    public List<Equipment> getEquipmentsBySerial(String serial) {
        return equipmentDao.getEquipmentsBySerial(serial);
    }
}
