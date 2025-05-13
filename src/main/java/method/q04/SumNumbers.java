package method.q04;

public class SumNumbers {
	public static void main(String[] args) {
		
		calculateSum(2, 3);
	}
	
	//2つの数値を加算するメソッド
	public static int calculateSum(int num1, int num2) {
		System.out.println("第一引数：" + num1);
		System.out.println("第二引数：" + num2);
		
		int sum = num1 + num2;
		
		System.out.println("加算結果：" + sum);
		return sum;
	}
}
