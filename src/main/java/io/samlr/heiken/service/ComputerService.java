package io.samlr.heiken.service;

import io.samlr.heiken.entity.Computer;

import java.util.List;

public interface ComputerService {

    Computer addComputer(Computer computer);

    Computer getComputerById(Long id);

    List<Computer> getAllComputers();

    Computer getComputerByName(String name);

    Computer updateComputer(Computer computer);

    List<Computer> getComputerByDescription(String ip);
}
