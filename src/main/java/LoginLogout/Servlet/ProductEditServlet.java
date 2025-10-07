package LoginLogout.Servlet;

import java.io.IOException;
import java.util.List;

import LoginLogout.dao.CategoryDAO;
import LoginLogout.dao.ProductDAO;
import LoginLogout.model.Category;
import LoginLogout.model.Product;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/product-edit")
public class ProductEditServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);

        ProductDAO dao = new ProductDAO();
        Product product = dao.findById(id);
        request.setAttribute("product", product);
        
        //カテゴリ一覧を取得して渡す！
        CategoryDAO categoryDao = new CategoryDAO();
        List<Category> categories = categoryDao.findAll();
        request.setAttribute("categories", categories);

        //request.setAttribute("product", product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product-edit.jsp");
        dispatcher.forward(request, response);
    }
}
