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
	private static final long serialVersionUID = 1L;
	private static final CategoryDAO dao = new CategoryDAO();
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
    		//カテゴリー一覧を取得
    		List<CategoryBean> categoryList = dao.getCategories();
    		
    		//リクエストスコープにデータを保存
    		request.setAttribute("categoryList", categoryList);
    	} catch(Exception e) {
    		e.printStackTrace();
    		request.setAttribute("errorMessage", "カテゴリ情報の取得に失敗しました。");
    	}
    	
    	//JSPページにフォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("category-list.jsp");
        dispatcher.forward(request, response);

    }
}