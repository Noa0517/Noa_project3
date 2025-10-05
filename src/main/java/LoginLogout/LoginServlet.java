package LoginLogout;

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
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		RequestDispatcher dispatcher;
		
	//認証処理
	if ("Noa".equals(userId) && "0517".equals(password)) {
		HttpSession session = request.getSession();
		session.setAttribute("userId", userId);
		
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
>>>>>>> ea28131
		// カテゴリ一覧を取得してJSPに渡す
	    CategoryDAO dao = new CategoryDAO();
	    List<Category> categories = dao.findAll();
	    request.setAttribute("categories", categories);
	    dispatcher = request.getRequestDispatcher("addProduct.jsp");


		
<<<<<<< HEAD
=======
>>>>>>> ab5b6ec (Add ProductListServlet for product listing)
>>>>>>> ea28131
		//RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.jsp");
		//商品登録画面に遷移
		dispatcher = request.getRequestDispatcher("RegisterAdd.jsp");
		
		//RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.jsp");
		//dispatcher.forward(request, response);
	}else{
		//認証失敗時はログイン画面に戻す
		request.setAttribute("errorMessage", "ユーザーIDまたはパスワードが違います");
	    dispatcher = request.getRequestDispatcher("Login.jsp");
	}
		dispatcher.forward(request, response);
	}
}

