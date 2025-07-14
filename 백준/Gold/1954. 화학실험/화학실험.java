import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[][] functions = new int[n][2];

		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			functions[i][0] = Integer.parseInt(st.nextToken()); // a
			functions[i][1] = Integer.parseInt(st.nextToken()); // b
		}

		int m = Integer.parseInt(br.readLine());
		int[][] values = new int[n][m + 1];

		for (int i = 0; i < n; i++) {
			int a = functions[i][0];
			int b = functions[i][1];
			for (int j = 1; j <= m; j++) {
				values[i][j] = a * j + b;
			}
		}

		for (int tCandidate = 1; tCandidate <= m - n + 1; tCandidate++) {
			int target = values[0][tCandidate];
			int total = tCandidate;
			boolean match = true;

			for (int i = 1; i < n; i++) {
				boolean found = false;
				for (int j = 1; j <= m; j++) {
					if (values[i][j] > target) {
						match = false;
						break;
					}
					if (values[i][j] == target) {
						total += j;
						found = true;
						break;
					}
				}
				if (!match || !found) {
					match = false;
					break;
				}
			}

			if (match && total == m) {
				System.out.println(target);
				return;
			}
		}

		System.out.println(0);
	}
}
