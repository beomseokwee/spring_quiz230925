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
	
	public List<RealEstate> selectRealEstateListByAreaPrice(
			@Param("area") int area,
			@Param("price") int price);
	
	// myBatis가 성공된 행의 개수를 채워서 리턴해줌
	public int insertRealEstate(RealEstate realEstate);
	
	
	//(realtorId, address, area, type, price,rentPrice);
	
	public int insertRealEstateAsField(
			//파라미터 2개 이상이면 map으로 만든다(@Param)
			
			@Param("realtorId") int realtorId,
			@Param("address") String address,
			@Param("area") int area,
			@Param("type") String type,
			@Param("price") int price,
			@Param("rentPrice") Integer rentPrice
			);
}