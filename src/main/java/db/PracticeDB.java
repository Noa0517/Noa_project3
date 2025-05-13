package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PracticeDB {

	//MySQLの接続情報
	private static final String URL = "jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC&useSSL=false";
	private static final String USER = "root";
	private static final String PASSWORD = "Noa20010517&&";
	
	//接続取得メソッド
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
	
	//データベース更新
	public static void refreshDB(Connection conn) {
		try (Statement stmt = conn.createStatement()) {
			stmt.execute("FLUSH TABLES;");
		} catch (SQLException e) {
		}
	}
	
	public static void main(String[] args) {
		try (Connection conn = getConnection()){
			System.out.println("DB接続成功");
			
			//データベースを最新の状態に更新
			refreshDB(conn);
			//商品一覧を取得
			listProducts(conn);
			
		} catch (SQLException e) {
			System.out.println("DB接続失敗： " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void listProducts(Connection conn) {
		
		if (conn == null) {
			System.out.println("データベースに接続できません。商品一覧を取得できません。");
			return;
		}
		
		String sql = "SELECT * FROM Products";
		
		try (Statement stmt = conn.createStatement()){
			
			ResultSet rs = stmt.executeQuery(sql);
			
			if (!rs.isBeforeFirst()) {
				System.out.println("商品データが取得できませんでした。");
				return;
			}
			
			System.out.println("---productsテーブルのすべての商品情報を表示---");
			while (rs.next()) {
				System.out.println("id： " + rs.getInt("id"));
				System.out.println("name： " + rs.getString("name"));
				System.out.println("price： " + rs.getDouble("price"));
				System.out.println("stock：" + rs.getInt("stock"));
				System.out.println("category_id： " + rs.getInt("category_id"));
				System.out.println();
			}
			
		}catch (SQLException e) {
			System.out.println("商品一覧の取得失敗：" + e.getMessage());
		}
	}
}


//$ java -cp ".;C:\Program Files\Java\jdk-24\lib\mysql-connector-j-9.2.0.jar" db.PracticeDB
