package LoginLogout.Servlet;

import java.io.IOException;
import java.util.List;

import LoginLogout.dao.CategoryDAO;
import LoginLogout.dao.ProductDAO;
import LoginLogout.model.Category;
import LoginLogout.model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/product-update")
public class ProductUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

     // パラメータ取得
        String idStr = request.getParameter("id");
        String name = request.getParameter("name");
        String priceStr = request.getParameter("price");
        String stockStr = request.getParameter("stock");
        String categoryIdStr = request.getParameter("categoryId");
        
     // バリデーション
        if (name == null || name.trim().isEmpty()) {
            request.setAttribute("error", "商品名は必須です");
            
         //カテゴリ一覧を再取得
            CategoryDAO categoryDao = new CategoryDAO();
            List<Category> categories = categoryDao.findAll();
            request.setAttribute("categories", categories);
            
            request.getRequestDispatcher("product-edit.jsp").forward(request, response);
            return;
        }
        
        int id = 0;
        int price = 0;
        int stock = 0;
        int categoryId = 0;
        
        try {
            id = Integer.parseInt(idStr);
            price = Integer.parseInt(priceStr);
            stock = Integer.parseInt(stockStr);
            categoryId = Integer.parseInt(categoryIdStr);
        } catch (NumberFormatException e) {
            request.setAttribute("error", "価格・在庫・カテゴリIDは数値で入力してください");
            request.getRequestDispatcher("product-edit.jsp").forward(request, response);
            return;
        }

        if (price < 0 || stock < 0) {
            request.setAttribute("error", "価格と在庫は0以上で入力してください");
            request.getRequestDispatcher("product-edit.jsp").forward(request, response);
            return;
        }
        
     // 更新処理
        Product product = new Product(id, name, price, stock, categoryId);
        ProductDAO dao = new ProductDAO();
        dao.update(product);

        // 一覧へリダイレクト
        response.sendRedirect("product-list");
    }
}