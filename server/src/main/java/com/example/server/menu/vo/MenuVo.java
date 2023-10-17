package com.example.server.menu.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class MenuVo  {
	private String adminId;
	private String menuId;
	private String upperMenuId;
	private String typeCd;
	private String menuNm;
	private String menuDesc;
	private String linkUrl;
	private String fullLinkUrl;
	private String level;
	private int menuOrder;
	private String level2MenuRowspan;
	private String htmlUrl;

	private String menuWithAuthSearchType;
	private String menuWithAuthControlType;

	private List<Map<String, Object>> treeData = new ArrayList<Map<String, Object>>();
	
	
	/** 검색조건 **/
	private String oldSearchInput;
	private String oldSearchInputVal;
	private String oldTypeCd;
	
	private String adminUserId;
}