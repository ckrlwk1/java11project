package com.example.server;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.server.common.sys.UserVo;
import com.example.server.common.util.CommonUtil;

@RestController
public class LoginCustomController {
	
	@RequestMapping(value="/duplicationLogin")
	public ModelAndView login(HttpServletRequest req, HttpServletResponse res) throws Exception {
		return new ModelAndView("common/error/duplicationLogin");
	}
	
	
	
	
	
	
	
}
