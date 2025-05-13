package method.q07;

public class SumNumbers2 {
	public static void main(String[] args) {
		
		//整数と実数を定義
		int num1 = 5;
		double num2 = 3.3;
		
		int result = calculateSum(num1, num2);
		
		System.out.println("第一引数(整数)；" + num1);
		System.out.println("第二引数(実数)：" + num2);
		System.out.println("加算結果：" + result);
	}
	
	public static int calculateSum(int a, double b) {
		return (int)(a+b);
	}
}
