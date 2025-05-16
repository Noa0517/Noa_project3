<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*, yourpackage.CategoryDTO" %>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8>"
    <title>カテゴリ一覧</title>
    <style>
        table{
            width: 50%;
            border-collapse: collapse;
        }
        th, td{
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
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
             List<CategoryDTO> categories = (List<CategoryDTO>) request.getAttribute("categoryList");
             if (categoryList != null){
                 for (Category category : categoryList) {
         %>
         <tr>
             <td><%= category.getCategoryId() %></td>
             <td><%= category.getCategoryName() %></td>
         </tr>
         <%
                 }
            }
         %>
     </table>
</body>
</html>