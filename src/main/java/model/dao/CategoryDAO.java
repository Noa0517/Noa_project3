package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entity.CategoryBean;

public class CategoryDAO {
	private static final String URL = "jdbc:mysql://localhost:3306/categories?serverTimezone=UTC&useSSL=false";
	//private static final String URL = "jdbc:mysql://localhost:3306/categories?serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASS = "Noa20010517&&";
	private Connection con = null;
	
	public void connect() {
		try {
			//DBに接続
			con = DriverManager.getConnection(URL, USER, PASS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<CategoryBean> select() {
		Statement stmt = null;
		ResultSet rs = null;
		List<CategoryBean> categoryList = new ArrayList<>();
		String sql = "SELECT * FROM categories;";
		
		try {
			connect();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				CategoryBean sb = new CategoryBean();
				sb.setId(rs.getInt("category_id"));
				sb.setName(rs.getString("category_name"));
				categoryList.add(sb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		disconnect();
		return categoryList;
	}
	
	public void disconnect() {
		try {
			if(con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
