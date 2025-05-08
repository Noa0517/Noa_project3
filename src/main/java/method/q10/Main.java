package method.q10;

public class Main {
	public static void main(String[] args) {
		EvenNumber evenNumber = new EvenNumber();
		
		int[] numbers = {3, 2, 5, 6, 7, 25, 10, 51, 88, 98};
		
		//偶数の個数
		int evenCount = evenNumber.getEvenNumbers(numbers);
		
		//結果表示
		System.out.println("[3, 2, 5, 6, 7, 25, 10, 51, 88, 98]には、偶数が" + evenCount + "個あります。");
	}

}
