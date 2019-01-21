package dao;

import java.util.List;

import entity.Lore;

public interface LoreDAO {
	List<Lore>  findByCourseId(int id) throws Exception;
}
