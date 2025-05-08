package basic.q06;

import java.util.Scanner;

public class ShowSeasons {
	
	public static void main(String[] args) {
		System.out.println("整数を入力してください");
		
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		switch (a) {
			case 12: case 1: case 2:
				System.out.println(a + "月は冬です");
				break;
			case 3: case 4: case 5:
				System.out.println(a + "月は春です");
				break;
			case 6: case 7: case 8:
				System.out.println(a + "月は夏です");
				break;
			case 9: case 10: case 11:
				System.out.println(a + "月は秋です");
				break;
			default :
				System.out.println(a+"月は存在しないです。");
		}
	}

}
