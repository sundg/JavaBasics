package dao;

import entity.User;

public interface UserDAO {
	User findByUsername(String username) throws Exception;
	
	void save(User user) throws Exception;
}
