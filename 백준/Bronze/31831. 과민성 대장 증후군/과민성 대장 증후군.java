import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] score = new int[n];
		int total = 0;
		int count = 0;
		
		for(int i = 0; i < n; i++) {
			score[i] = sc.nextInt();
			total += score[i];
			if(total < 0) {
				total = 0;
			}
			if(total >= m) {
				count++;
			}
		}
		System.out.println(count);
		sc.close();
	}
}