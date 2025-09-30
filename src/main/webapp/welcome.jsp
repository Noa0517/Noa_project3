<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="true" %>
<%
    String userId = (String) session.getAttribute("userId");
    if (userId == null) {
        request.setAttribute("errorMessage", "ログインしてください");
        RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
        dispatcher.forward(request, response);
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ようこそ</title>
</head>
<body>
    <h2>ログイン成功</h2>
    <p>ようこそ、<strong><%= session.getAttribute("userId") %></strong> さん！</p>
    <form action="LogoutServlet" method="post">
        <input type="submit" value="ログアウト">
    </form>
</body>
</html>