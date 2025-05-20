package model.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	//データベースの接続情報
	private static final String URL = "jdbc:mysql://localhost:3306/product_db";
	private static final String USER = "Noa";
	private static final String PASSWORD = "Noa20010517&&";
	
	//データベース接続を取得するメソッド
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
	
	//接続を安全に閉じるメソッド
	public static void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
