import java.util.Scanner;

public class Main {
	public static int count = 0;

	public static void main(String[] agrs) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		recursion(n);
		System.out.print(count + " ");
		count = 0;
		dynamicPrograming(n);
		System.out.print(count);

	}

	public static int recursion(int n) {
		if (n == 1 || n == 2) {
			count++;
			return 1;
		} else {
			return recursion(n - 1) + recursion(n - 2);
		}

	}

	public static int dynamicPrograming(int n) {
		int[] dynamicPrograming = new int[n + 1];

		dynamicPrograming[1] = 1;
		dynamicPrograming[2] = 1;

		for (int i = 3; i <= n; i++) {
			count++;
			dynamicPrograming[i] = dynamicPrograming[i - 1] + dynamicPrograming[i - 2];
		}

		return dynamicPrograming[n];
	}
}