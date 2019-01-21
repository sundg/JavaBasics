package dao;

import java.util.List;

import entity.Sale;

public interface SaleDAO {
	List<Sale> findTop() throws Exception;
}
