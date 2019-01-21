package com.sdg.dao;

import java.util.List;

import com.sdg.annotation.MyAnnotation;
import com.sdg.entity.Question;

@MyAnnotation
public interface QuestionMapper {
	List<Question> findAll();
}
