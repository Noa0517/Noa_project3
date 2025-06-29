<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>カテゴリ登録</title>
</head>
<body>
    <h2>カテゴリ登録フォーム</h2>

    <c:if test="${not empty errorMessage}">
        <p style="color:red">${errorMessage}</p>
    </c:if>

    <form action="CategoryRegisterServlet" method="post">
        <label>カテゴリID：</label>
        <input type="text" name="categoryId" value="${param.categoryId}" /><br/>

        <label>カテゴリ名：</label>
        <input type="text" name="categoryName" value="${param.categoryName}" /><br/>

        <input type="submit" value="登録" />
    </form>

    <br/>
    <a href="category-list.jsp">一覧ページへ戻る</a>
</body>
</html>