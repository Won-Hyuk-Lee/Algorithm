import java.util.Scanner;

public class Main {

    static Integer dp[];
    static int arr[];
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int N = in.nextInt();
        
        dp = new Integer[N + 1];
        arr = new int[N + 1];
        
        for(int i = 1; i <= N; i++) {
            arr[i] = in.nextInt();
        }
        
        dp[0] = 0;   // 계단 0의 값은 0
        if (N >= 1) {
            dp[1] = arr[1]; // 첫번째 계단의 값은 arr[1]
        }
        
        if (N >= 2) {
            dp[2] = arr[1] + arr[2]; // 두 번째 계단의 값은 첫 번째 계단과 두 번째 계단의 합
        }
        
        System.out.println(find(N));
    }
    
    static int find(int N) {
        // 아직 탐색하지 않은 N번째 계단
        if(dp[N] == null) {
            // N-2 계단에서 오는 경우와 N-3 계단을 거쳐 N-1 계단을 거쳐 오는 경우 중 큰 값을 선택
            dp[N] = Math.max(find(N - 2), find(N - 3) + arr[N - 1]) + arr[N];
        }
        
        return dp[N];
    }
}
