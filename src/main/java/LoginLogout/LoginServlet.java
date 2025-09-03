package LoginLogout;

import java.io.IOException;

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
	//仮の認証処理
	if ("root".equals(userId) && "1234".equals(password)) {
		HttpSession session = request.getSession();
		session.setAttribute("userId", userId);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("welcom.jsp");
		dispatcher.forward(request, response);
	}else{
		//認証失敗時はログイン画面に戻す
		request.setAttribute("errorMessage", "ユーザーIDまたはパスワードが違います");
	    RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
	}
}
}