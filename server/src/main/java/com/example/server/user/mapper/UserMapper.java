package com.example.server.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.server.common.sys.UserVo;

@Mapper
public interface UserMapper {

	UserVo test();

	UserVo getUserInfo(UserVo userVo);

	List<UserVo> getAdminUserList(UserVo userVo);

}
