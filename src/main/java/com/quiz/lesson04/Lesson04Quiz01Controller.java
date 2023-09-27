package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBO;
import com.quiz.lesson04.domain.Seller;

@RequestMapping("/lesson04/quiz01")
@Controller // jsp로 보낼 때는 @ResponseBody가 없어야 한다.
public class Lesson04Quiz01Controller {
	
	
	@Autowired
	private SellerBO sellerBO;
	
	// 회원가입 페이지
	// http://localhost/lesson04/ex01/sign-up-view
	@RequestMapping(path = "/add-seller-view", method = RequestMethod.GET)
	public String SellerView() {
		return "lesson04/addSeller"; // jsp view 경로
	}
	
	@PostMapping("/add-seller")
	public String Seller(
			@RequestParam("nickname") String nickname,
			@RequestParam(value="profileImageUrl", required=false) String profileImageUrl, 
			@RequestParam(value="temperature", required=false) double temperature) {
		
		// DB Insert
		sellerBO.addSeller(nickname, profileImageUrl, temperature);
		
		return "lesson04/afterAddSeller";
	}
	
	// 최신 판매자 한명 가져오는 페이지
		// http://localhost/lesson04/quiz01/seller-info
	@GetMapping("/get-info")
	public String getLatestSellerView(
			@RequestParam(value="id", required=false) Integer id,
			Model model) {
		
		Seller seller = null;
		if (id == null) {
			seller = sellerBO.getLatestSeller();
		}else {
			seller = sellerBO.getSellerById(id);
		}
		
		// DB select 조회
		
		model.addAttribute("result", seller);
		model.addAttribute("title", "판매자 정보");
		
		//  View - Model - Controller
		return "lesson04/getLatestSeller"; // 결과 jsp 경로
	}
	
	

}
