<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, model.entity.CategoryBean" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>カテゴリ一覧</title>
    <style>
      table {
        border: 1px solid black;
        border-collapse: collapse;
      }
      th, td {
        padding: 5px;
        text-align: left;
        border: 1px solid black;
      }
    </style>
</head>
<body>

<h2>カテゴリ一覧</h2>

<%
List<CategoryBean> categoryList = (List<CategoryBean>) request.getAttribute("categoryList");

if(categoryList == null) {
%>
	<p>カテゴリ情報を取得できませんでした。</p>
<%
} else if (categoryList.isEmpty()) {
%>
	<p>登録されたカテゴリがありません。</p>
<%
} else {
%>
	<table border="1">
    	<tr>
        	<th>カテゴリID</th>
        	<th>カテゴリ名</th>
    	</tr>
<%
	for (CategoryBean categoryItem : categoryList) {
%>
		<tr>
			<td><%= categoryItem.getId() %></td>
			<td><%= categoryItem.getName() %></td>
		</tr>
<%
	}
%>
	</table>
<%
}
%>

</body>
</html>
