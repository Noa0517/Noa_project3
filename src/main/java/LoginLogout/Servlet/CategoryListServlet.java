package LoginLogout.Servlet;

import java.io.IOException;
import java.util.List;

import LoginLogout.dao.CategoryDAO;
import LoginLogout.model.Category;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/add-product-form")

public class CategoryListServlet extends HttpServlet {
	  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
	    CategoryDAO dao = new CategoryDAO();
	    List<Category> categories = dao.findAll();
	    request.setAttribute("categories", categories);
	    RequestDispatcher dispatcher = request.getRequestDispatcher("addProduct.jsp");
	    dispatcher.forward(request, response);
	  }
	}

