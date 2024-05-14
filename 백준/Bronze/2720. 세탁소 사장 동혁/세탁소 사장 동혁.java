import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(); // 케이스갯수
		int q = 25; // 쿼터
		int d = 10; // 다임
		int n = 5; // 니켈
		int p = 1; // 페니
		for (int i = 0; i < t; i++) {
			int c = sc.nextInt(); // 센트
			System.out.print(c / q + " ");
			c = c % q;
			System.out.print(c / d + " ");
			c = c % d;
			System.out.print(c / n + " ");
			c = c % n;
			System.out.println(c / p);
		}
	}
}