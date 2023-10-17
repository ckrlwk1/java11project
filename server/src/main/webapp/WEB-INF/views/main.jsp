<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%-- <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %> --%>

<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>



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
</head>
<script>


var actionUrl = "";
$(document).ready(function() {
	ajaxCall('test');

});

function test (b){ 
	console.log("test 호출완료");
}


</script>
<body>
<!-- <div id="loading" style="display:none;"><img id="loading-image" src="/images/loading.gif" alt="Loading..."></div> -->

<!-- <form id="logOutForm" name="logOutForm" action="/logoutProc"></form> -->
<!-- <form id="mainForm" name="mainForm" method="post"> -->
<!-- 	<input type="hidden" id="level2MenuNm" name="level2MenuNm" value=""> -->
<!-- 	<input type="hidden" id="level2MenuId" name="level2MenuId" value=""> -->
<!-- 	<input type="hidden" id="level3MenuNm" name="level3MenuNm" value="main"> -->
<!-- 	<input type="hidden" id="level3MenuId" name="level3MenuId" value="main"> -->
<!-- 	<input type="hidden" name="totalListCount" id="totalListCount"> -->
<!-- 	<input type="hidden" name="adminUserId" id="adminUserId" value="han"> -->
<!-- 	<input type="hidden" id="menuWithAuthSearchType" name="menuWithAuthSearchType" value=""> -->
<!-- 	<input type="hidden" id="menuWithAuthControlType" name="menuWithAuthControlType" value="">	 -->
<!-- 	<input type="hidden" name="passwordStatus" id="passwordStatus" value=""> -->
<!-- 	<input type="hidden" name="certificationStatus" id="certificationStatus" value=""> -->
<!-- </form> -->
	<!--MMS 인증 입력 모달 -->
	

		<jsp:include page="/menu/selectLeftMenuList" />
				<div class="section">
					<!-- s: header -->
					<header class="header_type01">
						<h3 class="title_type02"><b>서비스</b></h3>
						<span id="refreshInterval">
							<select id="selRefresh" onchange="javascript:changeRefresh(this.value)">
								<option value="1">1분</option>
								<option value="5">5분</option>
								<option value="10">10분</option>
							</select>
						</span>
					</header>
					<!-- e: header -->
					<!-- s: board -->
					<div class="board_type01">
						<div id="xnotiHtml"></div>
					</div>
					<!-- e: board -->
				</div>
				
			</main>
			<!-- e: mainContent -->

		</div>
		<!-- e: body -->

		<!-- s: footer -->
		<footer class="footer_container">
			<div class="footer_inner">
				<p class="copyright">COPYRIGHT SK TELECOM CO., LTD. ALL RIGHTS RESERVED.</p>
			</div>
		</footer>
		<!-- e: footer -->
	</div>

</body>
</html>