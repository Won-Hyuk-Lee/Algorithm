import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			int length[] = new int[3];
			length[0] = sc.nextInt();
			length[1] = sc.nextInt();
			length[2] = sc.nextInt();

			Arrays.sort(length);

			if (length[0] == 0) {
				break;
			} else if (length[0] + length[1] <= length[2]) {
				System.out.println("Invalid");
			} else if (length[0] == length[1] && length[1] == length[2]) {
				System.out.println("Equilateral");
			} else if (length[0] == length[1] || length[1] == length[2] || length[0] == length[2]) {
				System.out.println("Isosceles");
			} else {
				System.out.println("Scalene");
			}

		}

	}

}