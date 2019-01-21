package dao;

import java.util.List;

import entity.Emp;

public interface EmpDAO {
    //�鿴���е�Ա��
	List<Emp> findAll() throws Exception;
	//����
	//insert into emp values(null,?,?,?);
	void save(Emp emp) throws Exception;
	//ɾ��
	//delete from emp where id=?
	void del(int id) throws Exception;
	//����id��ѯĳһ����¼
	Emp findById(int id) throws Exception;
	//����
	//update emp set name=?,salary=?,age=? where id=?;
	void update(Emp emp) throws Exception;
}
