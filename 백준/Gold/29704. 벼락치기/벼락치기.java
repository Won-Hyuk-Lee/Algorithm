import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        
        int[] dp = new int[T+1];
        int totalCost = 0;
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            totalCost += cost;
            
            for (int j = T; j >= day; j--) {
                dp[j] = Math.max(dp[j], dp[j-day] + cost);
            }
        }
        
        System.out.println(totalCost - dp[T]);
    }
}