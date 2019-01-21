package dao;

import java.util.List;

import entity.Emp;

public interface EmpDAO {
    //查看所有的员工
	List<Emp> findAll() throws Exception;
	//增加
	//insert into emp values(null,?,?,?);
	void save(Emp emp) throws Exception;
	//删除
	//delete from emp where id=?
	void del(int id) throws Exception;
	//根据id查询某一条记录
	Emp findById(int id) throws Exception;
	//更新
	//update emp set name=?,salary=?,age=? where id=?;
	void update(Emp emp) throws Exception;
}
