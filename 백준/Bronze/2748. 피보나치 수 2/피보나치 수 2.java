import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] dp = new long[91];
        dp[1] = 1;
        int n = Integer.parseInt(br.readLine());
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2]; 
        }
        System.out.print(dp[n]);
    }
}