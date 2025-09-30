package LoginLogout.Servlet;

import java.io.IOException;

import LoginLogout.dao.ProductDAO;
import LoginLogout.model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/add-product")
public class RegisterServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		//String name = request.getParameter("name");
		//int price = Integer.parseInt(request.getParameter("price"));
		//int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		
		String name = request.getParameter("name");
		String priceStr = request.getParameter("price");
		String stockStr = request.getParameter("stock");
		String categoryIdStr = request.getParameter("categoryId");

	    
		//未入力チェック
		if (name == null || name.isEmpty() ||
				priceStr == null || priceStr.isEmpty() ||
						categoryIdStr == null || categoryIdStr.isEmpty()) {
			
			request.setAttribute("errorMessage", "すべての項目を入力してください");
			request.getRequestDispatcher("addProduct.jsp").forward(request, response);
			return;
		}
		
		//数値チェック
		int price = Integer.parseInt(priceStr);
	    int stock = Integer.parseInt(stockStr);
	    int categoryId = Integer.parseInt(categoryIdStr);
	    
	    //マイナスチェック
	    if (price < 0 || stock < 0) {
	    	request.setAttribute("errorMessage", "価格と在庫数は0以上で入力してください");
	    	request.getRequestDispatcher("addProduct.jsp").forward(request, response);
	        return;
	    }
		
		Product product = new Product(name, price, stock, categoryId);
		ProductDAO dao = new ProductDAO();
		dao.insert(product);
	    
		response.sendRedirect("product-list.jsp"); // 登録後に一覧画面へ
		
	}

}
