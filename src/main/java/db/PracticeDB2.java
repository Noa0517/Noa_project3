package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PracticeDB2 {

	//MySQLの接続情報
	private static final String URL = "jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC&useSSL=false";
	//private static final String URL = "jdbc:mysql://localhost:3306/product_management?serverTimezone=UTC&useSSL=false";
	private static final String USER = "root";
	private static final String PASSWORD = "Noa20010517&&";
	
	//接続取得メソッド
	public static Connection getConnection2() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
	
	//データ更新
	public static void updateProduct2(Connection conn) {
		System.out.println("---商品の価格と在庫を更新①---");
		
		Scanner scanner = new Scanner(System.in);
		
		//更新する商品IDを入力①
		System.out.println("商品IDを入力してください： ");
		int productId1 = scanner.nextInt();
		
		//更新する価格を入力①
		System.out.println("価格を入力してください： ");
		double newPrice1 = scanner.nextDouble();
		
		//更新する在庫数を入力①
		System.out.println("在庫数を入力してください： ");
		int newStock1 = scanner.nextInt();
		
		System.out.println("---商品の価格と在庫を更新②---");
		
		//更新する商品IDを入力②
		System.out.println("商品IDを入力してください： ");
		int productId2 = scanner.nextInt();
		
		//更新する価格を入力②
		System.out.println("価格を入力してください：");
		double newPrice2 = scanner.nextDouble();
		
		//更新する在庫数を入力②
		System.out.println("在庫数を入力してください：");
		int newStock2 = scanner.nextInt();
		
		String sql = "UPDATE Products SET price = ?, stock = ? WHERE id = ?";
		
		int rowsUpdates1 = 0;
		int rowsUpdated2 = 0;
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)){
			//1件目の商品更新
			stmt.setDouble(1, newPrice1);
			stmt.setInt(2, newStock1);
			stmt.setInt(3, productId1);
			int rowsUpdated1 = stmt.executeUpdate();
			
			//2件目の商品更新
			stmt.setDouble(1, newPrice2);
			stmt.setInt(2, newStock2);
			stmt.setInt(3, productId2);
			rowsUpdated2 = stmt.executeUpdate();
			
			//更新成功件数を計算
			int totalUpdated = rowsUpdated1 + rowsUpdated2;
			
			//1件でも失敗したらロールバックする
			if (rowsUpdated1 == 0 || rowsUpdated2 == 0) {
				System.out.println("2件すべての更新に失敗しました。");
				System.out.println("更新成功件数：" + totalUpdated + "件");
				conn.rollback();
				System.out.println("ロールバックしました。");
			} else {
				conn.commit();
				System.out.println("コミット成功");
				System.out.println("更新成功件数： " + totalUpdated + "件");
				
				System.out.println("更新内容①：商品ID： " + productId1 + ", 価格: " + newPrice1 + ", 在庫数: " + newStock1);
				System.out.println("更新内容②： 商品ID: " + productId2 + ", 価格: " + newPrice2 + ", 在庫数: " + newStock2);
			}
			
		} catch (SQLException e) {
			try {
				conn.rollback();
				System.out.println("ロールバックしました。");
			} catch (SQLException rollbackEx) {
				System.out.println("ロールバック失敗：" + rollbackEx.getMessage());
			}
			System.out.println("更新失敗: " + e.getMessage());
		}
	}
	
	//複数商品IDと更新後の在庫数を更新する
	public static void updateStockLevels(Connection conn, Map<Integer, Integer> stockUpdates) {
		try {
			conn.setAutoCommit(false);
			
			try (PreparedStatement stmt = conn.prepareStatement("UPDATE Products SET stock = ? WHERE id = ?")){
				
				for(Map.Entry<Integer, Integer> entry : stockUpdates.entrySet()) {
					System.out.println("在庫更新: 商品ID " + entry.getKey() + " の在庫を " + entry.getValue() + " に更新");
					stmt.setInt(1,  entry.getValue());
					stmt.setInt(2, entry.getKey());
					stmt.addBatch();
				}
				
				int[] updateCounts = stmt.executeBatch();
				for (int count : updateCounts) {
					if (count == 0) {
						throw new SQLException("在庫更新失敗：影響を受けた行なし");
					}
				}
				
				conn.commit();
			} catch (SQLException e) {
				conn.rollback();
				System.out.println("在庫更新エラー： " + e.getMessage());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try (Connection conn = getConnection2()){
			System.out.println("DB接続成功");
			
			//商品の在庫更新処理を追加
			Map<Integer, Integer> stockUpdates = new HashMap<>();
			stockUpdates.put(1, 50);
			stockUpdates.put(2, 30);
			updateStockLevels(conn, stockUpdates);
			
			updateProduct2(conn);
			
		} catch (SQLException e) {
			System.out.println("DB接続失敗： " + e.getMessage());
			e.printStackTrace();
		}
	}
	

	
	public static void listProducts2(Connection conn) {
		
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
