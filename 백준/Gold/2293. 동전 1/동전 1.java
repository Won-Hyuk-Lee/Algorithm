import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n, k;
    private static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        dp = new int[k + 1];
        dp[0] = 1; // 기본적으로 dp[0]은 1로

        // 동전 종류 입력
        for(int i = 0 ; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 가능한 경우의 수
        for(int i = 0; i < n; i++) {
            for (int j = arr[i]; j <= k; j++) {
                dp[j] += dp[j - arr[i]];
            }
        }
        System.out.println(dp[k]);
    }
}
