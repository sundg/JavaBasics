package dao;


import java.util.List;


import entity.User;

public interface UserDAO {
	User findByUsername(String username) throws Exception;
	void addUser(User user) throws Exception;
	//查看所有的员工
	List<User> findAll() throws Exception;
}
