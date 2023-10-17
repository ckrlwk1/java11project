<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/common/commonHeaderTag.jsp" %>

<style>
#loading { width: 100%; height: 100%; top: 0px; left: 0px; position: fixed; display: block; opacity: 0.7; background-color: #fff; z-index: 999; text-align: center; }
#loading.open {display: block !important;} 
#loading-image { position: absolute; top: 50%; left: 50%; z-index: 100; transform: translate(-50%, -50%);}
button#reIssueButton[disabled] {
background-color: #f2f2f2;
}

</style>

<!-- <body oncontextmenu='return false' onselectstart='return false' ondragstart='return false'> -->
<body>

<form id="mainForm" name="mainForm" method="post">
</form>


<div id="loading" style="display:none;"><img id="loading-image" src="${pageContext.request.contextPath}/images/loading.gif" alt="Loading..." /></div>

<form id="logOutForm" name="logOutForm" action='<c:url value='/logoutProc'/>'></form>
	<!--MMS 인증 입력 모달 -->
	<div class="container">
		<!-- s: header -->
		<header class="header_container">
			<div class="header_inner">
				<h1 class="logo">
					<a href="${pageContext.request.contextPath}/main" style="cursor: pointer;">
						<img src="${pageContext.request.contextPath}/images/pub/logo_sktelecom01.png" alt="SK Telecom 로고" />
					</a>
				</h1>
				<div class="r_inner">
					<span class="userInfo">
						<strong>${userVo.adminNm }</strong>님
					</span>
					<a href="#" onclick="javascript:logoutConfirm();" class="btn_logout">로그아웃</a>
				</div>
			</div>
		</header>
		<!-- e: header -->

		<!-- s: body -->
		<div class="body_container">
			<!-- s: LNB -->
			<aside class="lnb_container">
				<div class="lnb_inner">
					<h2 class="hidden_obj">메뉴</h2>
					<nav class="menu_wrap">
						<ul>
							<c:forEach items="${level2MenuList}" var="level2MenuList" varStatus="level2MenuListStatus">
								<li>
									<a href="#" class="m1" title="전시 관리">설정</a>
									<c:forEach items="${level3MenuList}" var="level3MenuList" varStatus="level2MenuListStatus">
										<c:choose>
											<c:when test="${level2MenuList.menuId eq level3MenuList.upperMenuId}">	
												<ul class="depth">
													<li class="m2">
					                                	<a title="배너 관리" href="#" onclick="javascript: selectMenuLink('${level3MenuList.linkUrl}')">
					                                		${level3MenuList.menuNm }
					                                	</a>	
													</li>
												</ul>
											</c:when>
											<c:otherwise>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</li>
							</c:forEach>
<!-- 							<li> -->
<!-- 								<a href="#" class="m1" title="전시 관리">설정</a>					 -->
<!-- 								<ul class="depth"> -->
<!-- 									<li class="m2">				 -->
<!-- 	                                	<a title="배너 관리" href="#" onclick="javascript:selectMenuLink('/front/banner/selectBannerListMain', 'Y', 'Y', '1599049446158', '1590995897633', '전시 관리', '배너 관리')"> -->
<!-- 	                                		접근 권한 관리 -->
<!-- 	                                	</a> -->
<!-- 				                    </li>									 -->
<!-- 								</ul>				 -->
<!-- 								<ul class="depth">			 -->
<!-- 									<li class="m2"> -->
<!-- 										<a title="POP-UP 관리" href="#" onclick="javascript:selectMenuLink('/front/popup/selectPopupListMain', 'Y', 'Y', '1599049446158', '1590995897652', '전시 관리', 'POP-UP 관리')"> -->
<!-- 	                                		사용자 관리 -->
<!-- 	                                	</a> -->
<!-- 				                    </li>									 -->
<!-- 								</ul>		 -->
<!-- 								<ul class="depth">			 -->
<!-- 									<li class="m2"> -->
<!-- 	                                	<a title="공지사항 등록" href="#" onclick="javascript:selectMenuLink('/customer/notice/noticeListMain', 'Y', 'Y', '1599049446158', '1590995897576', '전시 관리', '공지사항 등록')"> -->
<!-- 	                                		시스템 설정 관리 -->
<!-- 	                                	</a> -->
<!-- 				                    </li>									 -->
<!-- 								</ul>					 -->
<!-- 							</li> -->
							
							
<%-- 						<c:forEach items="${level2MenuList}" var="level2MenuList" varStatus="level2MenuListStatus"> --%>
<%-- 							<c:choose> --%>
<%-- 								<c:when test="${!empty level2MenuId && level2MenuList.menuId eq level2MenuId }"> --%>
<!-- 							<li class="on open"> -->
<%-- 								</c:when> --%>
<%-- 								<c:otherwise> --%>
<!-- 							<li> -->
<%-- 								</c:otherwise> --%>
<%-- 							</c:choose> --%>
<%-- 								<a href="#" class="m1" title="${level2MenuList.menuNm}">${level2MenuList.menuNm}</a>					 --%>
<%-- 								<c:forEach items="${level3MenuList}" var="level3MenuList" varStatus="level3MenuListStatus"> --%>
<%-- 									<c:choose> --%>
<%-- 										<c:when test="${level2MenuList.menuId eq level3MenuList.upperMenuId}"> --%>
<!-- 									<ul class="depth"> -->
<%-- 											<c:choose> --%>
<%-- 												<c:when test="${!empty level3MenuId && level3MenuList.menuId eq level3MenuId }"> --%>
<!-- 										<li class="m2 on"> -->
<%-- 												</c:when> --%>
<%-- 												<c:otherwise> --%>
<!-- 										<li class="m2"> -->
<%-- 												</c:otherwise> --%>
<%-- 											</c:choose> --%>
<%-- 		                                	<a title="${level3MenuList.menuNm}" href="#" --%>
<%-- 		                                	onclick="javascript:selectMenuLink('${pageContext.request.contextPath}${level2MenuList.linkUrl}${level3MenuList.linkUrl}', '${level3MenuList.authTypeSearch }', '${level3MenuList.authTypeControl }', '${level2MenuList.menuId }', '${level3MenuList.menuId }', '${level2MenuList.menuNm }', '${level3MenuList.menuNm }')"> --%>
<%-- 		                                		${level3MenuList.menuNm} --%>
<!-- 		                                	</a> -->
<!-- 					                    </li>									 -->
<!-- 									</ul> -->
<%-- 										</c:when> --%>
<%-- 										<c:otherwise> --%>
<%-- 										</c:otherwise> --%>
<%-- 									</c:choose> --%>
<%-- 								</c:forEach> --%>
<!-- 							</li> -->
<%-- 						</c:forEach> --%>
						</ul>
					</nav>				
				</div>
				<button type="button" class="btnFold"><span>LNB 영역 열고닫기</span></button>
			</aside>
			<!-- e: LNB -->

			<!-- s: mainContent -->
			<main class="body_inner" id="mainContent">
				<!-- s: header -->
				<header class="header_type01">
					<div class="breadcrumb">
						<button type="button" class="btn_type01 sm" onclick="refreshFunc();"><i class="fa fa-redo"></i></button>
						<span class="depth"><a href="${pageContext.request.contextPath}/main">Home</a></span>
                    	<c:if test="${!empty level2MenuNm  }">
						<span class="depth" title="${level2MenuNm}">${level2MenuNm}</span>
						</c:if>
						<c:if test="${!empty level3MenuNm && level3MenuNm ne 'main'}">
						<em class="depth" title="${level3MenuNm}">${level3MenuNm}</em>
						</c:if>
					</div>
					<h2 class="title_type01" id="title_type01">${level3MenuNm }</h2>
				</header>
				<!-- e: header -->