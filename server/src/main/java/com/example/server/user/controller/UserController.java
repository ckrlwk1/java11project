package com.example.server.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.server.common.util.ApiResponseUtil;
import com.example.server.user.service.UserService;

@RestController
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/selectAdminList")
	public ModelAndView selectAdminList(Model model
			, HttpServletResponse response
			, HttpServletRequest request
			, HttpSession session) throws Exception{
		System.out.println("------------------------------ test");
		ModelAndView mav = new ModelAndView("admin/adminList");
		
		
		return mav;
	}
	
	@PostMapping("/selectUserListMain")
	public ResponseEntity<?> authorization(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return ApiResponseUtil.getResponseEntity(userService.getAdminUserList());
	}
	
	
	
	
	
	
	
}
