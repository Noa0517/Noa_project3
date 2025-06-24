package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * データベース接続を管理するクラス
 */

public class ConnectionManager {
	
	private static final String URL = "jdbc:mysql://localhost:3306/categories?serverTimezone=UTC&useSSL=false";
	//private static final String URL = "jdbc:mysql://localhost:3306/categories?serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASS = "Noa20010517&&";
	
	//JDBCドライバのロード(静的初期化ブロック)
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("JDBCドライバのロードに失敗しました。", e);
		}
	}
	
	/**
	 * データベース接続を取得する
	 * @return Connection データベース接続
	 * @throws SQLException データベース接続エラー
	 */
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASS);
	}
}