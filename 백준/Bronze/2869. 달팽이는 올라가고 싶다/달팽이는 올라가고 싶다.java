import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt(); // 올라감
		int b = sc.nextInt(); // 미끄러짐
		int v = sc.nextInt(); // 정상높이
		int result = 0;
		int day = (v - b) / (a - b);

		if ((v - b) % (b - a) != 0) {
			day++;
		}

		System.out.println(day);

	}
}
