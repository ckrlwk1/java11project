package com.example.server.common.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.example.server.common.sys.UserVo;

public class CommonUtil {

	public static UserVo getSecurityInfo() {
		
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			UserVo userVo = (UserVo)authentication.getPrincipal();
			return userVo;
		} catch (Exception e) {
			return null;
		}	
	}
}