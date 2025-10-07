<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="LoginLogout.model.Product" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head><title>商品編集</title></head>
<body>
<h2>商品編集</h2>

<%
    Product product = (Product) request.getAttribute("product");
    if (product != null) {
%>

<c:if test="${not empty error}">
  <p style="color:red">${error}</p>
</c:if>

<form action="product-update" method="post">
    <input type="hidden" name="id" value="<%= product.getProductId() %>" />

    <label>商品名:
      <input type="text" name="name" value="<%= product.getName() %>" />
    </label><br />

    <label>価格:
      <input type="number" name="price" value="<%= product.getPrice() %>" min="0" required />
    </label><br />

    <label>在庫数:
      <input type="number" name="stock" value="<%= product.getStock() %>" min="0" required />
    </label><br />

    <label>カテゴリ:
      <select name="categoryId">
        <c:forEach var="c" items="${categories}">
          <option value="${c.categoryId}"
            <c:if test="${c.categoryId == product.categoryId}">selected</c:if>>
            ${c.categoryName}
          </option>
        </c:forEach>
      </select>
    </label><br />
    
    <input type="submit" value="更新" />
</form>
<%
    } else {
%>
<p>商品情報が取得できませんでした。</p>
<%
    }
%>
</body>
</html>