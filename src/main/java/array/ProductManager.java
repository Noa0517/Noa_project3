package array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager{
	private static List<Product> productList = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int choice;
		
		do {
			System.out.println("---メニュー---");
			System.out.println("1: 商品追加");
			System.out.println("2: 商品情報取得");
			System.out.println("3: 商品検索");
			System.out.println("4: 商品すべて表示");
			System.out.println("5: 商品削除");
			System.out.println("0: 終了");
			System.out.println("操作を選択してください。");
			choice = scanner.nextInt();
			scanner.nextLine();
			
			switch (choice) {
			case 1:
				addProduct(scanner);
				break;
			case 2:
				getProductInfo(scanner);
				break;
			case 3:
				searchProduct(scanner);
				break;
			case 4:
				displayAllProducts();
				break;
			case 5:
				deleteProduct(scanner);
				break;
			case 0:
				System.out.println("プログラムを終了します。");
				break;
			default:
				System.out.println("無効な入力です。再度入力してください。");
			}
		}while (choice != 0);
		
		scanner.close();
	}
		
	    //商品追加
	private static void addProduct(Scanner scanner) {
		System.out.print("商品IDを入力してください： ");
		String productId = scanner.nextLine();
			
		System.out.print("商品名を入力してください： ");
		String productName = scanner.nextLine();
			
		//商品名が空の場合、例外をスルーする
		if (productName == null || productName.trim().isEmpty()) {
			System.out.println("無効な入力です。入力された商品名：" + productName);
			try {
				throw new Exception("無効な入力です。商品名を正しく入力してください。");
			} catch (Exception e) {
				System.out.println("java.lang.Exception：" + e.getMessage());
				//スタックトレースを表示
				e.printStackTrace();
				return;
			}
		}
		
		System.out.print("価格を入力してください： ");
		double price = Double.parseDouble(scanner.nextLine());
		
		//価格がマイナスの場合エラーメッセージを表示
		if (price < 0) {
			System.out.println("無効な入力です。入力された価格：" + price);
			try {
				throw new Exception("無効な入力です。価格を正しく入力してください。");
			} catch(Exception e) {
				System.out.println("java.lang.Exception：" + e.getMessage());
				e.printStackTrace();
				return;
			}
		}
			
		System.out.print("在庫数を入力してください： ");
		int stock = Integer.parseInt(scanner.nextLine());
		
		//在庫数がマイナスの場合エラーメッセージを表示
		if (stock < 0) {
			System.out.println("無効な入力です。入力された在庫数：" + stock);
			try {
				throw new Exception("無効な入力です。在庫を正しく入力してください。");
			} catch(Exception e) {
				System.out.println("java.lang.Exception：" + e.getMessage());
				e.printStackTrace();
				return;
			}
		}
			
		
		try {
			Product product = new Product(productId, productName, price, stock);
			productList.add(product);
			System.out.println(product);

		}catch (IllegalArgumentException e) {
			System.out.println("エラー： " + e.getMessage());
		}
	}
	
	//商品情報取得
	private static void getProductInfo(Scanner scanner) {
        System.out.print("商品情報を取得する商品名を入力してください。: ");
        String productName = scanner.nextLine();
        
        for (Product product : productList) {
            if (product.getProductName().equals(productName)) {
                System.out.println("取得した商品は、" + product + "です。");
                return;
            }
        }
        System.out.println("商品が見つかりませんでした。");
    }
	
	//商品検索
	private static void searchProduct(Scanner scanner) {
        System.out.print("検索する商品名を入力してください: ");
        String searchName = scanner.nextLine();
        
        boolean found = false;
        
        for (Product product : productList) {
            if (product.getProductName().contains(searchName)) {
                System.out.println(product);
                found = true;
            }
        }
        
        if (!found) {
        	System.out.println("商品が見つかりませんでした。");
        }
    }
	
	//商品すべて表示
	private static void displayAllProducts() {
        if (productList.isEmpty()) {
            System.out.println("商品リストは空です。");
        } else {
        	System.out.println("商品をすべて表示します。");
            for (Product product : productList) {
                System.out.println(product);
            }
        }
    }
	
	//商品削除
	private static void deleteProduct(Scanner scanner) {
        System.out.print("削除したい商品IDを入力してください: ");
        String productId = scanner.nextLine();
        
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductId().equals(productId)) {
                productList.remove(i);
                System.out.println("商品IDが" + productId + "の商品を削除しました。");
                return;
            }
        }
        System.out.println("指定した商品IDの商品が見つかりませんでした。");
    }
}