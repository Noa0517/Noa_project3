package product;

public class Main {
	public static void main(String[] args) {
        ProductManager manager = new ProductManager();
        
        System.out.println("---商品を5つ追加してすべての商品を追加する---");

        // 商品の追加
        manager.addProduct(new Product(1, "冷蔵庫", 50000, 10));
        manager.addProduct(new DiscountedProduct(2, "ソファ", 30000.0, 5, 0.30));
        manager.addProduct(new Product(3, "米", 2000, 3));
        manager.addProduct(new Product(4, "小説", 1500, 4));
        manager.addProduct(new Product(5, "Tシャツ", 1500, 5));

        // 商品リストを表示
        manager.displayProducts();
        
        //IDが1の商品を削除
        System.out.println("---商品を1つ削除してすべてを表示する---");
        manager.removeProduct(1);
        
        //商品リストを再表示
        manager.displayProducts();
        
        //商品情報を取得
        Product rice = manager.getProductByName("米");
        
        //米の情報を表示
        if(rice != null) {
        	System.out.println("---商品名「米」の情報を表示する---");
        	System.out.println("Product: id=" + rice.getId() + ", name=" + rice.getName() + ", price=" + rice.getPrice() + ", stock=" + rice.getStock());
        }else {
        	System.out.println("---商品が見つかりませんでした---");
        }
        
        //ソファを割引商品として追加
        System.out.println("---商品名「ソファ」の情報と割引率30％の情報を表示する---");
        manager.addProduct(new DiscountedProduct(2, "ソファ", 30000.0, 5, 0.30));
        Product sofa = manager.getProductByName("ソファ");
        manager.displayProductInfo(sofa);
        
        //商品検索
        System.out.println("---商品名「Tシャツ」を検索して表示する---");
        Product tshirt = manager.search("Tシャツ");
        manager.displayProductInfo(tshirt);
    }
}
