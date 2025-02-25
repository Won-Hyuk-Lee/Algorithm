import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] dp = precompute();
        
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(dp[b] - dp[a - 1]).append("\n");
        }
        System.out.print(sb);
    }

    private static boolean check(String s) {
        if (s.length() < 3 || s.charAt(0) >= s.charAt(1)) return false;
        boolean up = true;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) return false;
            if (up && s.charAt(i) < s.charAt(i - 1)) up = false;
            else if (!up && s.charAt(i) > s.charAt(i - 1)) return false;
        }
        return !up;
    }

    private static int[] precompute() {
        int[] ret = new int[1000001];
        for (int i = 1; i <= 1000000; i++) {
            ret[i] = ret[i - 1] + (check(Integer.toString(i)) ? 1 : 0);
        }
        return ret;
    }
}