package com.example.server.user.service;

import com.example.server.common.code.BusinessCode;
import com.example.server.common.sys.UserVo;

public interface UserService {

	UserVo test();

	UserVo getUserInfo(UserVo userVo);

	BusinessCode getAdminUserList();

}
