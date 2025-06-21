package servlet; 

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.CategoryDAO;
import model.entity.CategoryBean;

//登録データを一覧表示するクラス
//@webServlet("/category-list")
public class CategoryListServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		
		CategoryDAO sdao = new CategoryDAO();
		List<CategoryBean> categoryList = sdao.select();
		
		req.setAttribute("categoryList" , categoryList);
		
		RequestDispatcher rd = req.getRequestDispatcher("/category-list.jsp");
		rd.forward(req, res);
		
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException{
		doPost(req, res);
	}
}
