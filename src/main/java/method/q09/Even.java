package method.q09;

public class Even {
	public static void main(String[] args) {
		
		//判定数値
		checkEven(7);
	}
	
	public static void checkEven(int number) {
		if(number % 2 == 0) {
			System.out.println(number + "は偶数です。");
		} else {
			System.out.println(number + "は奇数です。");
		}
	}
}
