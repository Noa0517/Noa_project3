package LoginLogout.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import LoginLogout.model.Product;

public class ProductDAO {
	
	private static final String URL = "jdbc:mysql://localhost:3306/categories?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
	private static final String USER = "root";
	private static final String PASS = "Noa20010517&&";
	
	public void insert(Product product) {
		  String sql = "INSERT INTO products (name, price, category_id) VALUES (?, ?, ?)";

		  try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
		       PreparedStatement stmt = conn.prepareStatement(sql)) {

		    stmt.setString(1, product.getName());
		    stmt.setInt(2, product.getPrice());
		    stmt.setInt(3, product.getCategoryId());

		    stmt.executeUpdate();

		  } catch (SQLException e) {
		    e.printStackTrace();
		  }
		}
}
