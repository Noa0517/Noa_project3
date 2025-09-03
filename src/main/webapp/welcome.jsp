<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String userId = (String) session.getAttribute("userId"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー画面</title>
</head>
<body>
<%=userId %>さん、こんにちは
<br><br>
<a href="LogoutServlet">ログアウト</a>
</body>
</html>