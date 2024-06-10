import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int time = sc.nextInt();
		int countA = 0, countB = 0, countC = 0;

		while (time > 0) {
			if (time >= 300) {
				time -= 300;
				countA++;
			} else if (time >= 60) {
				time -= 60;
				countB++;
			} else if (time >= 10) {
				time -= 10;
				countC++;
			}
			else
			{
				break;
			}
		}
		if(time == 0) System.out.print(countA + " " + countB + " " + countC);
		else System.out.println(-1);
	}
}
