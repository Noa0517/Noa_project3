package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.CategoryDAO;
import model.dao.ConnectionManager;
import model.entity.CategoryBean;

//@WebServlet("/category-list")

public class CategoryListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try (Connection connection = ConnectionManager.getConnection()){
    		CategoryDAO categoryDAO = new CategoryDAO(connection);
    		List<CategoryBean> categoryList = categoryDAO.getAllCategories();
    		
    		request.setAttribute("categoryList", categoryList);
    		RequestDispatcher dispatcher = request.getRequestDispatcher("category-list.jsp");
    		dispatcher.forward(request, response);
    	} catch (Exception e) {
    		e.printStackTrace();
    		response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "データ取得中にエラーが発生しました");
    	}
    }
}
