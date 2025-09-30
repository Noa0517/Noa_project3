package LoginLogout.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import LoginLogout.model.Category;

public class CategoryDAO {
	
	private static final String URL = "jdbc:mysql://localhost:3306/categories?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
	private static final String USER = "root";
	private static final String PASS = "Noa20010517&&";
	
	public List<Category> findAll() {
		List<Category> list = new ArrayList<>();
		String sql = "SELECT category_id, category_name FROM categories";
	    
		try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {
			
			while (rs.next()) {
				int id = rs.getInt("category_id");
				String name = rs.getString("category_name");
				System.out.println("カテゴリ取得: " + id + " - " + name);
				Category c = new Category(id, name);
				list.add(c);
			}
			
			System.out.println("カテゴリ取得完了: " + list.size() + "件");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
