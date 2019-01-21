package dao;


import java.util.List;


import entity.User;

public interface UserDAO {
	User findByUsername(String username) throws Exception;
	void addUser(User user) throws Exception;
	//�鿴���е�Ա��
	List<User> findAll() throws Exception;
}
