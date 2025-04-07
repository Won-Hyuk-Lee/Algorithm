import java.io.*;

public class Main {
    static final int MOD = 1_000_000_007;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        long[][] dp = new long[n + 1][2];
        dp[1][0] = 1;  
        dp[1][1] = 2;  
        
        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][1] % MOD;
            dp[i][1] = (2 * (dp[i - 1][0] + dp[i - 1][1])) % MOD;
        }
        
        System.out.println((dp[n][0] + dp[n][1]) % MOD);
    }
}