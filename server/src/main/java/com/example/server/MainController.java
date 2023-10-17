package com.example.server;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.server.common.sys.UserVo;
import com.example.server.common.util.CommonUtil;

@RestController
public class MainController {
	
	@RequestMapping(value="/")
	public ModelAndView login(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("----------------------------------------------------");
		return new ModelAndView("index");
	}
	
	@RequestMapping(value="/main")
	public ModelAndView htmlCheck(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		UserVo userVo = CommonUtil.getSecurityInfo();
		System.out.println("-----------------------------------------------------------------------------123123123123 /main");
		ModelAndView mav = new ModelAndView("main");
		mav.addObject("userVo",userVo);
		
		return mav;
	}
	
	
	
	
}
