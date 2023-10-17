package com.example.server.menu.service;

import java.util.List;
import java.util.Map;

import com.example.server.menu.vo.MenuVo;

public interface MenuService {

	List<MenuVo> selectMenuList(Map<String, Object> headerParam) throws Exception;

}
