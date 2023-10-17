<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/common/commonHeaderTag.jsp" %>
<!DOCTYPE html>
<html>
<%-- <%@ include file="/WEB-INF/views/common/common.jsp" %> --%>
<%-- <%@ include file="/WEB-INF/views/common/datepicker.jsp" %> --%>
<head>
<link type="text/css" href="/resources/css/pub/all.min.css" rel="stylesheet" >
<link type="text/css" href="/resources/css/pub/default.css" rel="stylesheet" >
<link type="text/css" href="/resources/css/custom-datepicker-jquery-ui.css" rel="stylesheet" >

<script type="text/javascript" src="/resources/js/pub/jquery.js"></script>
<script type="text/javascript" src="/resources/js/pub/ui.js"></script>
<script type="text/javascript" src="/resources/js/jquery/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="/resources/js/jquery/jquery-1.12.4.js"></script>
<script type="text/javascript" src="/resources/js/jquery/jquery-ui.js"></script>
<script type="text/javascript" src="/resources/js/common.js"></script>
<script type="text/javascript" src="/resources/css/custom/js/ismsUI.js"></script>
<script>
var commonActionUrl = "${commonActionUrl}";
$(document).ready(function() {
	ajaxCall("/user/selectUserListMain",null,"adminListCallback");
});

function adminListCallback(data){
	var arrWidth = new Array('5%', '10%', '10%', '12%', '12%', '10%'
			, '13%', '*%', '15%');
	var arrHeader = new Array('checkbox', '등록일(수정일)', '최근 접속 시간', '권한명', 'ID', '이름'
			, '연락처', '이메일', '상태');
	var arrAlign = new Array('center', 'center', 'center', 'center',  'center', 'center'
			, 'center', 'left', 'center');
	var arrVoId = new Array('checkbox:adminId', 'onclick:adminId', 'adminNm', 'adminId', 'adminId', 'adminId'
			, 'phoneNoFullNumber', 'email', 'adminStatusCdNm');
	drawTableGrid(arrWidth, arrHeader, arrAlign, arrVoId, data.resultData, "관리자 목록");
	
}

function dataView(data){
	console.log(data);
}


	
</script>
</head>
<body>
<jsp:include page="/menu/selectLeftMenuList" />
<!-- s: section -->
				<div class="section">
					<!-- s: header -->
					<header class="header_type01">
						<h3 class="title_type02"><div id="totalCount"></div></h3>
						&nbsp;
						<span class="selectBox01" style="width:70px;">
							<label for="" class="s_value">목록수</label>
			        		<select id="countPerListVal" name="countPerListVal" onchange="getPagingListData(1,this.value);">
					        	<option value="10" selected="selected">10</option>
					        	<option value="50">50</option>
					        	<option value="100">100</option>
					        </select>
						</span>
						건씩 보기
						<div class="rBox">
							<button id="btnDel" type="button" class="btn_type01 c02" onclick="javascript:deleteAdmin('N');">삭제</button>
							<button type="button" class="btn_type01 c04" onclick="javascript: adminUseInfoListExcelDown();"><i class="fa fa-file-excel"></i>어드민 사용 이력 출력</button>
							<button type="button" class="btn_type01 c04" onclick="javascript: adminListExcelDown();"><i class="fa fa-file-excel"></i> 엑셀로 저장</button>
							<button id="btnReg" type="button" class="btn_type01 c01" onclick="javascript:openAdminModal('I', '');">계정 등록</button>							
						</div>
					</header>
					<!-- e: header -->
					
					<!-- s: table -->
					<div class="table_type01">
						<div id="tableContents">
							
						</div>
					</div>
					<!-- e: table -->
					
					<!-- s: paging -->
					<div class="pageNavi_type01">
						<div id="paginationTag"></div>
					</div>
					<!-- e: paging -->
				</div>
</body>
</html>