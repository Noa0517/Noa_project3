package method.q05;

public class Main {
	public static void main(String[] args) {
		Triangle Triangle = new Triangle();
		
		//三角形の面積を計算
		double sum = Triangle.getTriangleArea(8, 5);
		
		//結果を表示
		System.out.println("底辺：" + 8);
		System.out.println("高さ：" + 5);
		System.out.println("三角形の面積：" + sum);
	}
}
