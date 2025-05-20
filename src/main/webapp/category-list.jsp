<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.entity.CategoryBean" %>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>カテゴリ一覧</title>
    <style>
        table { width: 50%; border-collapse: collapse; }
        th, td { border: 1px solid black; padding: 8px; text-align: left; }
     </style>
</head>
<body>
    <h2>カテゴリ一覧</h2>
    <table>
         <tr>
             <th>カテゴリID</th>
             <th>カテゴリ名</th>
         </tr>
         <%
         List<CategoryBean> categoryList = (List<CategoryBean>) request.getAttribute("categoryList");
         if (categoryList != null && !categoryList.isEmpty()){
             for (CategoryBean category : categoryList) {
         %>
         <tr>
             <td><%= category.getCategoryId() %></td>
             <td><%= category.getCategoryName() %></td>
         </tr>
         <%
                 }
            } else {
         %>
         <tr>
             <td colspan="2">カテゴリが見つかりません</td>
         </tr>
         <%
            }
         %>
     </table>
</body>
</html>