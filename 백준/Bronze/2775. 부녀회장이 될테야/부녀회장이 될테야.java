import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 15층까지 배열 생성
		int[][] house = new int[15][15];
         
		for(int i = 0; i < 15; i++)
        {
			house[i][1] = 1;	// 각층의 1호엔 1을 채운다.
			house[0][i] = i;	// 0층의 i호에는 i를 채운다.
		}
         
        //예를들어 1층의 3호를 계산하기 위해서는 1층 2호와 0층의 3호의 합을 구하면 된다.
 
		for(int i = 1; i < 15; i ++)
        {	// 1층부터 14층까지
 
			for(int j = 2; j < 15; j++)
            {	// 2호부터 14호까지
				house[i][j] = house[i][j - 1] + house[i - 1][j];
			}
		}
		
        //1층3호인 경우 0층 1호에1명, 0층2호에 2명, 0층3호에 3명이므로 6명
        //2층3호인 경우 1층 1호 = 1명 + 1층 2호 = 3명 + 1층 3호 = 6명 으로 총 10명이 나와야 함
        
		// 테스트 케이스 실행 		
		int testCase = sc.nextInt();
		
		for(int i = 0; i < testCase; i++)
        {
			int k = sc.nextInt();
			int n = sc.nextInt();
            
			System.out.println(house[k][n]);
		}
	}
 
}