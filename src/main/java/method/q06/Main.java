package method.q06;

public class Main {
	public static void main(String[] args) {
		Circle circle = new Circle();
		
		//円の面積を計算
		double area = circle.getCircleArea(5);
		
		//結果を表示
		System.out.println("半径：5");
		System.out.println("円の面積：" + area);
	}
}
