package com.example.server.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.server.common.code.BusinessCode;
import com.example.server.common.code.Code.CodeName;
import com.example.server.common.code.Code.ServiceError;
import com.example.server.common.sys.UserVo;
import com.example.server.user.mapper.UserMapper;
import com.example.server.user.service.UserService;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public UserVo test() {
		return userMapper.test();
	}

	@Override
	public UserVo getUserInfo(UserVo userVo) {
		userVo = userMapper.getUserInfo(userVo);
		return userVo;
	}

	@Override
	public BusinessCode getAdminUserList() {
		UserVo userVo = new UserVo();
		
		List<UserVo> adminList = userMapper.getAdminUserList(userVo); 
		
		
		return new BusinessCode(ServiceError.USER, CodeName.SUCCESS,adminList);
	}

}
