package method.q08;

public class Main {
	public static void main(String[] args) {
		SumLoop sumLoop = new SumLoop();
		
		//最小値から最大値までの合計を計算
		int result = sumLoop.sumLoop(1,100);
		
		//結果表示
		System.out.println("最小値：1");
		System.out.println("最大値：100");
		System.out.println("加算結果：" + result);
	}
}
