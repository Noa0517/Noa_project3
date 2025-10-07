package LoginLogout.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import LoginLogout.model.Product;

public class ProductDAO {
	
	//private static final String URL = "jdbc:mysql://localhost:3306/categories?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
	private static final String URL = "jdbc:mysql://localhost:3306/categories";
	private static final String USER = "root";
	private static final String PASS = "Noa20010517&&";
	
	public void insert(Product product) {
		  //String sql = "INSERT INTO products (name, price, category_id) VALUES (?, ?, ?)";
		  String sql = "INSERT INTO products (name, price, stock, category_id) VALUES (?, ?, ?, ?)";
		  
		  try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
			         PreparedStatement stmt = conn.prepareStatement(sql)) {

			        stmt.setString(1, product.getName());
			        stmt.setInt(2, product.getPrice());
			        stmt.setInt(3, product.getStock());
			        stmt.setInt(4, product.getCategoryId());

			        stmt.executeUpdate();

			        System.out.println("商品登録完了: " + product.getName());

			    } catch (SQLException e) {
			        e.printStackTrace();
			    }
	}
	
	public List<Product> findAll() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM products";

		  try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
		       PreparedStatement stmt = conn.prepareStatement(sql);
		  ResultSet rs = stmt.executeQuery()) {

		    //stmt.setString(1, product.getName());
		    //stmt.setInt(2, product.getPrice());
		    //stmt.setInt(3, product.getCategoryId());

		    //stmt.executeUpdate();
			  
			  while (rs.next()) {
	                int id = rs.getInt("product_id");
	                String name = rs.getString("name");
	                int price = rs.getInt("price");
	                int stock = rs.getInt("stock");
	                int categoryId = rs.getInt("category_id");

	                list.add(new Product(id,name, price, stock, categoryId));
			  }

		  } catch (SQLException e) {
		    e.printStackTrace();
		  }
		  return list;
		}
	
	public void delete(int id) {
	    String sql = "DELETE FROM products WHERE product_id = ?";

	    try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setInt(1, id);
	        int rows = stmt.executeUpdate();

	        if (rows > 0) {
	            System.out.println("商品削除完了: ID = " + id);
	        } else {
	            System.out.println("削除対象の商品が見つかりません: ID = " + id);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public Product findById(int id) {
	    Product product = null;
	    String sql = "SELECT * FROM products WHERE product_id = ?";

	    //try (Connection conn = getConnection();
	    try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setInt(1, id);
	        ResultSet rs = stmt.executeQuery();

	        if (rs.next()) {
	            product = new Product(
	                rs.getInt("product_id"),
	                rs.getString("name"),
	                rs.getInt("price"),
	                rs.getInt("stock"),
	                rs.getInt("category_id")
	            );
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return product;
	}
	
	public void update(Product product) {
	    String sql = "UPDATE products SET name = ?, price = ?, stock = ?, category_id = ? WHERE product_id = ?";

	    //try (Connection conn = getConnection();
	    try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setString(1, product.getName());
	        stmt.setInt(2, product.getPrice());
	        stmt.setInt(3, product.getStock());
	        stmt.setInt(4, product.getCategoryId());
	        stmt.setInt(5, product.getProductId());

	        stmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}


}
