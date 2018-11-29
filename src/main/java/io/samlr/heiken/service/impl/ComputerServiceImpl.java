package io.samlr.heiken.service.impl;

import io.samlr.heiken.dao.ComputerDao;
import io.samlr.heiken.entity.Computer;
import io.samlr.heiken.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("computerService")
public class ComputerServiceImpl implements ComputerService {

    @Autowired
    ComputerDao computerDao;

    @Override
    public Computer addComputer(Computer computer) {
        return computerDao.create(computer);
    }

    @Override
    public Computer getComputerById(Long id) {
        return computerDao.getById(id);
    }

    @Override
    public List<Computer> getComputerByIp(String ip) {
        return computerDao.getComputerByIp(ip);
    }

    @Override
    public List<Computer> getAllComputers() {
        return computerDao.getList();
    }

    @Override
    public Computer getComputerByName(String name) {
        return computerDao.getComputerByName(name);
    }

    @Override
    public Computer updateComputer(Computer computer) {
        return computerDao.update(computer);
    }
}
