import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		int num = sc.nextInt();
		
		System.out.println(a.charAt(num-1));

	}

}