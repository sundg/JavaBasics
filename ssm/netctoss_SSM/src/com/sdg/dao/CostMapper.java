package com.sdg.dao;

import java.util.List;

import com.sdg.common.MyAnnotation;
import com.sdg.entity.Cost;

@MyAnnotation
public interface CostMapper {
	List<Cost> findAll();
	
	void addCost(Cost cost);
}
