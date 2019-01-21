package dao;

import java.util.List;

import entity.Computer;

public interface ComputerDAO {
	List<Computer> findAll() throws Exception;
	
	Computer findById(int id) throws Exception;
}
