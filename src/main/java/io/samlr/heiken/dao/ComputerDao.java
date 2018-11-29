package io.samlr.heiken.dao;

import io.samlr.heiken.entity.Computer;

import java.util.List;

public interface ComputerDao extends BasicDao<Computer>{

    Computer getComputerByName(String name);

    List<Computer> getComputerByIp(String ip);
}
