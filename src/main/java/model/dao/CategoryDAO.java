package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	
	public void insert(CategoryBean category) throws SQLException {
	    String sql = "INSERT INTO categories (category_id, category_name) VALUES (?, ?)";

	    try (Connection con = ConnectionManager.getConnection();
	         PreparedStatement pstmt = con.prepareStatement(sql)) {

	        pstmt.setInt(1, category.getId());
	        pstmt.setString(2, category.getName());
	        pstmt.executeUpdate();
	    }
	}
	
	public boolean exists(int id) throws SQLException {
		String sql = "SELECT COUNT(*) FROM categories WHERE category_id = ?";
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return rs.getInt(1) > 0;
				}
			}
		}
		return false;
	}
}
