<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="LoginLogout.model.Product" %>
<%@ page import="LoginLogout.dao.ProductDAO" %>
<%
  ProductDAO dao = new ProductDAO();
  List<Product> products = dao.findAll(); // ← DAOに一覧取得メソッドを追加！
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>商品一覧</title>
</head>
<body>
  <h2>登録された商品一覧</h2>
  <table border="1">
    <tr><th>商品名</th><th>価格</th><th>カテゴリID</th></tr>
    <%
      for (Product p : products) {
    %>
      <tr>
        <td><%= p.getName() %></td>
        <td><%= p.getPrice() %></td>
        <td><%= p.getCategoryId() %></td>
      </tr>
    <%
      }
    %>
  </table>
</body>
</html>