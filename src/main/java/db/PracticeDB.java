package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

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
			System.out.println("データベースの更新失敗：" + e.getMessage());
		}
	}
	
	//新しい商品を追加
	public static void insertProducts(Connection conn) {
		System.out.println("---商品の登録---");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("商品名を入力してください： ");
		String name = scanner.nextLine();
		System.out.println("価格を入力してください： ");
		double price = scanner.nextDouble();
		System.out.println("在庫数を入力してください： ");
		int stock = scanner.nextInt();
		System.out.println("カテゴリーIDを入力してください： ");
		int category_id = scanner.nextInt();
		
		String sql = "INSERT INTO Products (name, price, stock, category_id) VALUES (?, ?, ?, ?)";
		
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setString(1, name);
			stmt.setDouble(2,  price);
			stmt.setInt(3,  stock);
			stmt.setInt(4, category_id);
			
			int rowsInserted = stmt.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("登録成功件数： " + rowsInserted);
				System.out.println("登録内容：\n商品名：" + name + ", 価格： " + price + ", 在庫数 : " + stock + ", カテゴリーID： " + category_id);
			}
		} catch (SQLException e) {
			System.out.println("商品追加の失敗： " + e.getMessage());
		}
	}
	
	//データ更新
	public static void updateProduct(Connection conn) {
		System.out.println("---商品の価格と在庫を更新---");
		
		Scanner scanner = new Scanner(System.in);
		
		//更新する商品IDを入力
		System.out.println("商品IDを入力してください： ");
		int productId = scanner.nextInt();
		
		//新しい価格を入力
		System.out.println("価格を入力してください： ");
		double newPrice = scanner.nextDouble();
		
		//新しい在庫数を入力
		System.out.println("在庫数を入力してください： ");
		int newStock = scanner.nextInt();
		
		String sql = "UPDATE Products SET price = ?, stock = ? WHERE id = ?";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setDouble(1, newPrice);
			stmt.setInt(2, newStock);
			stmt.setInt(3, productId);
			
			int rowsUpdated = stmt.executeUpdate();
			System.out.println("更新成功行数： " + rowsUpdated + "件");
			
			if (rowsUpdated > 0) {
				System.out.println("更新内容：\n商品ID： " + productId + ", 価格： " + newPrice + ", 在庫数： " + newStock);
			} else {
				System.out.println("更新失敗");
			}
		} catch (SQLException e) {
			System.out.println("更新失敗： " + e.getMessage());
		}
	}
	
	//データ削除
	public static void deleteProductsByCategory(Connection conn) {
		System.out.println("商品情報の削除処理開始");
		
		Scanner scanner = new Scanner(System.in);
		
		//削除するIDを入力
		System.out.println("---商品の削除---");
		System.out.println("商品IDを入力してください： ");
		int category_id = scanner.nextInt();
		
		String sql = "DELETE FROM Products WHERE category_id = ?";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setInt(1,  category_id);
			
			int rowsDeleted = stmt.executeUpdate();
			System.out.println("削除成功件数： " + rowsDeleted + "件");
			
			if (rowsDeleted > 0) {
				System.out.println("カテゴリーID " + category_id + " を削除しました。");
			} else {
				System.out.println("指定されたカテゴリに該当する商品が見つかりませんでした。");
			}
		} catch (SQLException e) {
			System.out.println("商品削除の失敗： " + e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		try (Connection conn = getConnection()){
			System.out.println("DB接続成功");
			
			//データベースを最新の状態に更新
			refreshDB(conn);
			//商品一覧を取得
			listProducts(conn);
			//商品メソッドを呼び出す
			insertProducts(conn);
			//商品情報更新メソッドを呼び出す
			updateProduct(conn);
			//商品削除メソッドを呼び出す
			deleteProductsByCategory(conn);
			
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