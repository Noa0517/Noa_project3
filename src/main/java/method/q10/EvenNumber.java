package method.q10;

public class EvenNumber {
	public int getEvenNumbers(int[] numbers) {
		int count = 0;
		for (int number : numbers) {
			if(number % 2 == 0) {
				count++;
			}
		}
		return count;
	}
}
