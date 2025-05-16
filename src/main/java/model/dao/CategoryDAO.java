package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entity.CategoryBean;

public class CategoryDAO {
	public static List<CategoryBean> getAllCategories(){
		List<CategoryBean> categories = new ArrayList<>();
		
		try (Connection conn = ConnectionManager.getConnection();
				Statement stmt = conn.createStatement();
						ResultSet rs = stmt.executeQuery("SELECT category_id, category_name FROM categories")){
			
			while (rs.next()) {
				categories.add(new CategoryBean(rs.getInt("category_id"), rs.getString("category_name")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categories;
	}

}