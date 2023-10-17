package com.example.server.menu.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.server.menu.mapper.MenuMapper;
import com.example.server.menu.service.MenuService;
import com.example.server.menu.vo.MenuVo;

@Component
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private MenuMapper menuMapper;
	
	@Override
	public List<MenuVo> selectMenuList(Map<String, Object> param) throws Exception {
		List<Map<String, Object>> selectMenuTreeList = selectMenuTreeList(param);
		List<MenuVo> selectMenuList = new ArrayList<MenuVo>();
		if( !selectMenuTreeList.isEmpty() ) {
			for( int i = 0; i < selectMenuTreeList.size(); i++) {
				MenuVo menuVo = new MenuVo();
				menuVo.setMenuId( selectMenuTreeList.get(i).get("menuId").toString() );
				menuVo.setMenuNm( selectMenuTreeList.get(i).get("menuNm").toString() );
				menuVo.setUpperMenuId( selectMenuTreeList.get(i).get("upperMenuId").toString() );
				menuVo.setLevel( selectMenuTreeList.get(i).get("level").toString() );
				menuVo.setTypeCd( selectMenuTreeList.get(i).get("typeCd").toString() );
				menuVo.setMenuDesc( selectMenuTreeList.get(i).get("menuDesc").toString() );
				menuVo.setLinkUrl(selectMenuTreeList.get(i).get("linkUrl").toString() );
				menuVo.setLevel2MenuRowspan(selectMenuTreeList.get(i).get("level2MenuRowspan").toString() );
				selectMenuList.add(i, menuVo);
			}
		}
		return selectMenuList;
	}
	
	
	public List<Map<String, Object>> selectMenuTreeList(Map<String, Object> param) throws Exception {
		return menuMapper.selectMenuTreeList(param);
	}

}
