import java.util.Scanner;

public class Main {

    // dp배열 초기화 (최대 40)
    static Integer[][] dp = new Integer[41][2];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        // 초기 값 설정
        dp[0][0] = 1;  // N=0일 때의 0 호출 횟수
        dp[0][1] = 0;  // N=0일 때의 1 호출 횟수
        dp[1][0] = 0;  // N=1일 때의 0 호출 횟수
        dp[1][1] = 1;  // N=1일 때의 1 호출 횟수

        int T = in.nextInt();
        
        while(T-- > 0) {
            int N = in.nextInt(); // N값 입력
            fibonacci(N); // N에 대한 피보나치 호출 횟수 계산
            System.out.println(dp[N][0] + " " + dp[N][1]);
        }
    }

    static Integer[] fibonacci(int N) {
        // N에 대한 0, 1 호출 횟수가 계산되지 않은 경우
        if(dp[N][0] == null || dp[N][1] == null) {
            // 각 N에 대한 0 호출 횟수와 1 호출 횟수를 재귀 계산
            dp[N][0] = fibonacci(N - 1)[0] + fibonacci(N - 2)[0];
            dp[N][1] = fibonacci(N - 1)[1] + fibonacci(N - 2)[1];
        }
        // N에 대한 0과 1 호출 횟수를 담고 있는 배열 반환
        return dp[N];
    }
}
