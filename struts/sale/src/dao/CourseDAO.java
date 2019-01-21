package dao;

import java.util.List;

import entity.Course;

public interface CourseDAO {
	List<Course> findAll() throws Exception;
}
