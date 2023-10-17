<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<script>
	<c:if test="${not empty loginErrorMessage}">
	alert('${loginErrorMessage}')
	</c:if>
</script>
<body>
	<div class="container">
    <form class="form-signin" method="post" action="/loginprc">
        <p class="text-center">
        </p>
        <p>
            <label for="username" class="sr-only">아이디</label>
            <input type="text" id="username" name="userid" class="form-control" placeholder="아이디" required="" autofocus="">
        </p>
        <p>
            <label for="password" class="sr-only">비밀번호</label>
            <input type="password" id="password" name="pw" class="form-control" placeholder="비밀번호" required="">
        </p>
        <button class="btn btn-lg btn-primary btn-block" type="submit">로그인</button>
    </form>

</div>
</body>
</html>