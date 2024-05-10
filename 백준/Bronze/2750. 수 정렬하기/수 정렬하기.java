import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // 시행 횟수
		int [] num = new int[n];
		
		for(int i =0; i<n;i++)
		{
			num[i] = sc.nextInt(); //배열에 삽입
		}
		
		Arrays.sort(num); //정렬
		
		for(int i =0;i<n;i++)
		{
			System.out.println(num[i]); //하나씩출력
		}
		

	}

}