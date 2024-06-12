import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b, c;
		int temp;

		while (true) {
			a = sc.nextInt();
			if (a == 0) {
				return;
			}
			b = sc.nextInt();
			c = sc.nextInt();

			if (a > c) {
				temp = c;
				c = a;
				a = temp;
			} else if (b > c) {
				temp = c;
				c = b;
				b = temp;
			}

			if (a * a + b * b == c * c) {
				System.out.println("right");
			} else {
				System.out.println("wrong");
			}
		}
	}
}