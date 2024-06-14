import java.util.Scanner;

public class Main {

    static Integer[] dp;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        dp = new Integer[N + 1]; //배열 초기화
        dp[0] = dp[1] = 0; //0과 1은 연산X

        System.out.print(recursion(N));
        sc.close();
    }

    // N을 1로 만드는 최소 연산 횟수를 계산하는 재귀 함수
    static int recursion(int N) {
        if (dp[N] == null) { // 아직 계산되지 않은 경우
            // 6으로 나누어질때
            if (N % 6 == 0) {
                dp[N] = Math.min(recursion(N - 1), Math.min(recursion(N / 3), recursion(N / 2))) + 1;
            }
            // 3으로만 나누어질때
            else if (N % 3 == 0) {
                dp[N] = Math.min(recursion(N / 3), recursion(N - 1)) + 1;
            }
            // 2로만 나누어질때
            else if (N % 2 == 0) {
                dp[N] = Math.min(recursion(N / 2), recursion(N - 1)) + 1;
            }
            // 2와 3으로 나누어지지 않을때
            else {
                dp[N] = recursion(N - 1) + 1;
            }
        }
        return dp[N];
    }
}
