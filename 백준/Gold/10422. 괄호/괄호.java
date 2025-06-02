import java.io.*;

public class Main {
	static final int MOD = 1_000_000_007;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int[] input = new int[t];
		int max = 0;
		for (int i = 0; i < t; i++) {
			input[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, input[i]);
		}
		long[] dp = new long[max + 1];
		dp[0] = 1;
		for (int i = 2; i <= max; i += 2) {
			for (int j = 0; j < i; j += 2) {
				dp[i] = (dp[i] + dp[j] * dp[i - 2 - j]) % MOD;
			}
		}
		for (int n : input) System.out.println(dp[n]);
	}
}
