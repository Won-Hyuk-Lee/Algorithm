import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int S = sc.nextInt();
		int A = sc.nextInt();
		
		if(S>A) {
			System.out.println(A/2);
		}
		else
		{
			System.out.println(S/2);
		}
	}
}
