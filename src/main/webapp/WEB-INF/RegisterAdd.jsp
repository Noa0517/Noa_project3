<%@ page import="java.util.List" %>
<%@ page import="model.Category" %>
<%
  CategoryDAO dao = new CategoryDAO();
  List<Category> categories = dao.findAll();
%>

<form action="add-product" method="post">
  商品名: <input type="text" name="name"><br>
  価格: <input type="number" name="price"><br>
  カテゴリ:
  <select name="categoryId">
    <%
      for (Category c : categories) {
    %>
      <option value="<%= c.getCategoryId() %>"><%= c.getCategoryName() %></option>
    <%
      }
    %>
  </select><br>
  <input type="submit" value="登録">
</form>