import java.util.*;

public class Main {
    
    // dp 배열을 초기화
    static int[] dp = new int[11];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        // 초기 값 설정
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        
        // 점화식에 따라 dp 배열 채우기
        for(int j = 4; j <= 10; j++) {
            dp[j] = dp[j-3] + dp[j-2] + dp[j-1];
        }
        
        for(int i = 0; i < t; i++) {
            int n = sc.nextInt();
            System.out.println(dp[n]);
        }
    }
}
