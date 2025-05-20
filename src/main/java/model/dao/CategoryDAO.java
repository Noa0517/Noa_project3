package model.dao;
//package model.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.CategoryBean;

public class CategoryDAO {
	
	//カテゴリ一覧を取得するメソッド
	public List<CategoryBean> getCategories(){
		List<CategoryBean> categoryList = new ArrayList<>();
		String sql = "SELECT * FROM categories;";
		
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()){
			
			while (rs.next()) {
				CategoryBean category = new CategoryBean(
						rs.getInt("category_id"),
						rs.getString("category_name")
						);
				categoryList.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categoryList;
	}
	
	//カテゴリを追加するメソッド
	public boolean addCategory(String categoryName) {
		String sql = "INSERT INTO categories (category_name) VALUES (?);";
		
		try (Connection  conn = ConnectionManager.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)){
			
			stmt.setString(1, categoryName);
			return stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//カテゴリを削除するメソッド
	public boolean deleteCategory(int categoryId) {
		String sql = "DELETE FROM categories WHERE category_id = ?;";
		
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)){
			
			stmt.setInt(1, categoryId);
			return stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}