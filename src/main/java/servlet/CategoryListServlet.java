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
		
		//DAOオブジェクトを生成
		CategoryDAO2 sdao =new CategoryDAO2();
		
		List<CategoryBean> categoryList = sdao.getAllCategories(); //追加
		
		System.out.println("取得したカテゴリリスト：" + categoryList);
		req.setAttribute("categoryList", categoryList); //追加
		
		//全件検索した結果
		CategoryDAO sdto = sdao.select();
			
			req.setAttribute("sdto", sdto);
		
		RequestDispatcher rd = req.getRequestDispatcher("/category-list.jsp");
		rd.forward(req, res);
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException{
		doPost(req, res);
	}
}
