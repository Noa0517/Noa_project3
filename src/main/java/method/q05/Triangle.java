package method.q05;

public class Triangle {
		public static void main(String[] args) {
			
			int base = 8;
			int height = 5;
			
			double area = getTriangleArea(base, height);
			
			//結果を表示
			System.out.println("底辺：" + base);
			System.out.println("高さ：" + height);
			System.out.println("三角形の面積：" + area);
		}
	
	public static double getTriangleArea(double base, double height) {
		return (base * height) / 2;
	}
}
