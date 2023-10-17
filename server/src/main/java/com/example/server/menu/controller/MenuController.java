package com.example.server.menu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.server.common.sys.UserVo;
import com.example.server.common.util.CommonUtil;
import com.example.server.menu.service.MenuService;
import com.example.server.menu.vo.MenuVo;

@RestController
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
	@RequestMapping("/selectLeftMenuList")
	public ModelAndView selectTopMenuList(HttpServletRequest request, HttpServletResponse response
			, ModelAndView mav, MenuVo menuVo, HttpSession session)throws Exception{
		Map<String, Object> headerParam = new HashMap<>();
		//2레벨 메뉴목록 조회
		headerParam.put("menuLevel", "2");
		
		
		List<MenuVo> level2MenuList = menuService.selectMenuList(headerParam);
		
		
		
		//3레벨 메뉴목록 조회		
		headerParam.put("menuLevel", "3");
		List<MenuVo> level3MenuList = menuService.selectMenuList(headerParam);
		
		
		System.out.println(level2MenuList.get(0).getMenuId());
		System.out.println("-----------------------------------------------------------123123123123");
		System.out.println(level3MenuList.get(0).getUpperMenuId());
		
		//로그인한 운영자의 권한에 연결 된 메뉴목록 조회
//		AdminVo adminVo = (AdminVo)session.getAttribute(CommonConstant.KEY_SESSIONUSER);
//		adminVo = adminService.selectAdminInfo(adminVo);
//		
//		AdminVo adminVo2 = new AdminVo();
//		setSessionInfo(session, adminVo2);
//		adminVo2.setAdminId(adminVo.getAdminId());
//		actionEventService.insertActionEvent(adminVo2, Keywords.ACTION_EVENT_SEARCH);
//		
//		MenuVo mv = new MenuVo();
//		setSessionInfo(session, mv);
//		mv.setAuthGroupId(adminVo.getAuthGroupId());
//		List<MenuVo> selectAuthMenuMappingList = authService.selectAuthMenuMappingList(mv, true);
		
//		setAuthWithMenuList(level2MenuList, level3MenuList, selectAuthMenuMappingList);
//
//		actionEventService.insertActionEvent(menuVo, Keywords.ACTION_EVENT_MOVE);
		
		
		
		System.out.println(level2MenuList.size());
		System.out.println(level3MenuList.size());
		
		mav.addObject("level2MenuList", level2MenuList);
		mav.addObject("level3MenuList", level3MenuList);
		
//		mav.addObject("level2MenuNm", menuVo.getLevel2MenuNm());
//		mav.addObject("level2MenuId", menuVo.getLevel2MenuId());
//
//		mav.addObject("level3MenuId", menuVo.getLevel3MenuId());		
//		mav.addObject("level3MenuNm", menuVo.getLevel3MenuNm());
		
		mav.addObject("menuWithAuthSearchType", "Y");		
		mav.addObject("menuWithAuthControlType", "Y");		

//		mav.addObject("adminUserId", menuVo.getRegUserId());		

		
		UserVo userVo = CommonUtil.getSecurityInfo();
		mav.addObject("userVo",userVo);
		mav.setViewName("common/leftMenuList");
		return mav;		
	}
	
	
	
	
	
	
	
}
