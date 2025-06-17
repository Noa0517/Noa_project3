import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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
	
	public ConnectionManager select() {
	//public List<CategoryBean> select() {
		Statement stmt = null;
		ResultSet rs = null;
		//List<CategoryBean> categoryList = new ArrayList<>();
		ConnectionManager sdto = new ConnectionManager();
		String sql = "SELECT * FROM categories;";
		
		try (Connection con = DriverManager.getConnection(USER, USER, PASS);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)){
			
			while (rs.next()) {
				CategoryBean category = new CategoryBean();
				category.setId(rs.getInt("category_id"));
				category.setName(rs.getString("category_name"));
				//categoryList.add(category);
			}
			rs.close();
			stmt.close();
		}
		byte categoryList;
	}
}
