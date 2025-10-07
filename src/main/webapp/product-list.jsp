<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*, LoginLogout.model.Product" %>

<html>
<head><title>商品一覧</title></head>
<body>
<h2>商品一覧</h2>

<table border="1">
    <tr>
        <th>ID</th><th>商品名</th><th>価格</th><th>在庫数</th><th>カテゴリID</th>
    </tr>
    <%
  List<Product> products = (List<Product>) request.getAttribute("products");
    %>
    
    <% if (products != null && !products.isEmpty()) { %>
  <% for (Product p : products) { %>

    <tr>
        <td><%= p.getProductId() %></td>
        <td><%= p.getName() %></td>
        <td><%= p.getPrice() %></td>
        <td><%= p.getStock() %></td>
        <td><%= p.getCategoryId() %></td>
    </tr>
    
    <td>
        <form action="product-delete" method="post" onsubmit="return confirm('本当に削除しますか？');">
            <input type="hidden" name="id" value="<%= p.getProductId() %>" />
            <input type="submit" value="削除" />
        </form>
        
        <form action="product-edit" method="get">
            <input type="hidden" name="id" value="<%= p.getProductId() %>" />
            <input type="submit" value="編集" />
        </form>
        
    </td>
    
    <%
            }
        } else {
    %>
    <tr><td colspan="5">商品が見つかりません</td></tr>
    <%
        }
    %>
</table>

</body>
</html>