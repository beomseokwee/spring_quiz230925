package com.quiz.lesson03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson03.domain.RealEstate;

@Repository
public interface RealEstateMapper {

	public RealEstate selectRealEstateById(int id);
	
	public List<RealEstate> selectRealEstateListByRentPrice(
			@Param("rentPrice1") int rentPrice);
}