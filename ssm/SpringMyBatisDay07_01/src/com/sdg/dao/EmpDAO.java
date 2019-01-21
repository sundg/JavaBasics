package com.sdg.dao;

import com.sdg.entity.Emp;
import com.sdg.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/8 0008.
 */
public class EmpDAO {
    public List<Emp> findAll(){
        SqlSession ss= MyBatisUtil.getSession();
        List<Emp> emps=ss.selectList("com.sdg.dao.EmpDAO.findAll");
        ss.close();
        return  emps;
    }
    public Emp findByEmpno(int empno){
    	SqlSession ss=MyBatisUtil.getSession();
    	Emp emp=ss.selectOne("com.sdg.dao.EmpDAO.findByEmpno", empno);
    	ss.close();
    	return emp;
    }
    
    public void addEmp(Emp emp){
    	SqlSession ss=MyBatisUtil.getSession();
    	try{
    		ss.insert("com.sdg.dao.EmpDAO.addEmp",emp);
    		//事物提交
    		ss.commit();
    	}catch(Exception ex){
    		//事物回滚
    		ss.rollback();
    	}finally{
    		
    		ss.close();
    	}
    	
    }
    
    public void update(Emp emp){
    	SqlSession ss=MyBatisUtil.getSession();
    	try {
			ss.update("com.sdg.dao.EmpDAO.update", emp);
			ss.commit();
		} catch (Exception e) {
			ss.rollback();
		}finally{
			ss.close();
		}
    }
    
   public void delete(int empno){
	   SqlSession ss=MyBatisUtil.getSession();
	   try{
		   ss.delete("com.sdg.dao.EmpDAO.delete",empno);
		   ss.commit();
	   }catch (Exception e) {
		   ss.rollback();
	   }finally{
		   ss.close();
	   }
   }
   
   //查询员工同时查询员工所在的部门信息
   public Map<String,Object> findEmpAndDeptByEmpno(int empno){
	   SqlSession ss=MyBatisUtil.getSession();
	   Map<String,Object> map=ss.selectOne("com.sdg.dao.EmpDAO.findEmpAndDeptByEmpno", empno);
	   ss.close();
	   return map;
   }
   
   //查询员工同时查询员工所在的部门信息
   public List<Map<String,Object>> findEmpAndDept(){
	   SqlSession ss=MyBatisUtil.getSession();
	   List<Map<String,Object>> list=ss.selectList("com.sdg.dao.EmpDAO.findEmpAndDept");
	   ss.close();
	   return list;
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
}
