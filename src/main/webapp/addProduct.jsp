<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="LoginLogout.model.Category" %>
<%@ page import="LoginLogout.dao.CategoryDAO" %>
<%
  List<Category> categories = (List<Category>) request.getAttribute("categories");
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>商品登録</title>
</head>
<body>

<h2>商品登録フォーム</h2>

<% String error = (String) request.getAttribute("errorMessage"); %>
<% if (error != null) { %>
  <p style="color:red;"><%= error %></p>
<% } %>

<form action="add-product" method="post">
  商品名: <input type="text" name="name"><br>
  価格: <input type="number" name="price"><br>
  在庫数: <input type="number" name="stock"><br>
  カテゴリ数: <%= categories == null ? "null" : categories.size() + "件" %>
<select name="categoryId">
<% if (categories != null && !categories.isEmpty()) { %>
  <% for (Category c : categories) { %>
    <option value="<%= c.getCategoryId() %>"><%= c.getCategoryName() %></option>
  <% } %>
  <% } else { %>
    <option disabled>カテゴリが取得できません</option>
  <% } %>
</select><br>

  <input type="submit" value="登録">
</form>

</body>
</html>