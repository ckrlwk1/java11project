package com.example.server.menu.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenuMapper {

	List<Map<String, Object>> selectMenuTreeList(Map<String, Object> param);

}
