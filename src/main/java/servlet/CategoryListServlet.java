package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.CategoryDAO;
import model.entity.CategoryBean;

@WebServlet("/category-list")

public class CategoryListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryDAO categoryDAO = new CategoryDAO();
        List<CategoryBean> categoryList = categoryDAO.getAllCategories();
        
        request.setAttribute("categoryList", categoryList);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/category-list.jsp");
        dispatcher.forward(request, response);
    }
}