import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int L, P, V;
		int i = 1;

		while (sc.hasNext()) {
			L = sc.nextInt();
			if (L == 0)
				break;
			else {
				P = sc.nextInt();
				V = sc.nextInt();
				int day = (V / P) * L;
				int remainingDays = V % P;
				if (remainingDays > L) {
					day += L;
				} else {
					day += remainingDays;
				}
				System.out.println("Case " + i + ": " + day);
				i++;
			}
		}
	}
}
