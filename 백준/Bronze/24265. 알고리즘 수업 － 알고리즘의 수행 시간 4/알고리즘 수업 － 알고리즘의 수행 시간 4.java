import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextInt(); //int로 선언할경우 범위 초과합니다.
		System.out.println(n*(n-1)/2); // 1부터 n-1까지의 합
		System.out.println(2); //2중for문의 시간 복잡도는 n^2
	}
}