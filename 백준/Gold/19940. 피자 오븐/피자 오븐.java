import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static final int MAX_N = 60;
    static String[] dp = new String[MAX_N + 1];
    static int[] d = {60, 10, -10, 1, -1};
    
    static boolean cmp(String a, String b) {
        int la = 0, lb = 0;
        
        for (int i = 0; i < 5; i++) {
            la += a.charAt(i) - '0';
            lb += b.charAt(i) - '0';
        }
        
        if (la != lb) return la < lb;
        else return a.compareTo(b) < 0;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        Arrays.fill(dp, "99999");
        dp[0] = "00000";
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            for (int k = 4; k >= 0; k--) {
                int nxt = cur + d[k];
                if (nxt < 0 || nxt > MAX_N) continue;
                
                char[] tmp = dp[cur].toCharArray();
                tmp[k]++;
                String newStr = new String(tmp);
                
                if (cmp(newStr, dp[nxt])) {
                    dp[nxt] = newStr;
                    q.offer(nxt);
                }
            }
        }
        
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] ans = new int[5];
            
            ans[0] += N / 60;
            N %= 60;
            
            for (int i = 0; i < 5; i++) {
                ans[i] += dp[N].charAt(i) - '0';
            }
            
            for (int i = 0; i < 5; i++) {
                sb.append(ans[i]).append(" ");
            }
            sb.append("\n");
        }
        
        System.out.print(sb);
    }
}