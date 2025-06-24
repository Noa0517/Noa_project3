package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entity.CategoryBean;

public class CategoryDAO {
	public List<CategoryBean> select() {
		List<CategoryBean> categoryList = new ArrayList<>();
		String sql = "SELECT * FROM categories";
		
		//try-with-resource文でリソースを自動管理
		try (Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			
			while (rs.next()) {
				CategoryBean category = new CategoryBean();
				category.setId(rs.getInt("category_id"));
				category.setName(rs.getString("category_name"));
				categoryList.add(category);
			}
			
		} catch (SQLException e) {
			System.err.println("データベースエラー：" + e.getMessage());
		}
		
		return categoryList;
	}
}
