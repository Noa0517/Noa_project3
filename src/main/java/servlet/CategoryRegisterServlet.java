package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.CategoryDAO;
import model.entity.CategoryBean;

//@WebServlet("/category-register")
@WebServlet("/CategoryRegisterServlet")
public class CategoryRegisterServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException {
    	request.getRequestDispatcher("category-register.jsp").forward(request, response);
    	
    	request.setCharacterEncoding("UTF-8");
    	
    	String categoryId = request.getParameter("categoryId");
    	String categoryName = request.getParameter("categoryName");
    	
    	StringBuilder errors = new StringBuilder();
    	
    	if (categoryId == null || categoryId.trim().isEmpty()) {
    		errors.append("カテゴリIDは必須です。<br/>");
    	}else {
    		try {
    			Integer.parseInt(categoryId);
    		}catch (NumberFormatException e) {
    			errors.append("カテゴリIDは数値で入力してください。<br/>");
    		}
    	}
    	
    	if (categoryName == null || categoryName.trim().isEmpty()) {
    		errors.append("カテゴリ名は必須です。<br/>");
    	}
    	
    	// エラーがあればフォームに戻す
    	if (errors.length() > 0) {
    		request.setAttribute("errorMessage", errors.toString());
    		request.getRequestDispatcher("category-register.jsp").forward(request, response);
    		return;
    	}
    	
    	// 登録処理
    	try {
    		CategoryBean category = new CategoryBean();
    		category.setId(Integer.parseInt(categoryId));
    		category.setName(categoryName);
    		
    		CategoryDAO dao = new CategoryDAO();
    		dao.insert(category); // DAOを使ってDBに登録
    		
    		// 登録後はカテゴリ一覧にリダイレクト
    		response.sendRedirect("category-list.jsp");
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    		request.setAttribute("errorMessage", "データベース登録中にエラーが発生しました。");
    		request.getRequestDispatcher("category-register.jsp").forward(request, response);
    	}
	}
}
