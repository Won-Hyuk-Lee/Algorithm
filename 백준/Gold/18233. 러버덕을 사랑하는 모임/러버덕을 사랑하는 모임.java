import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int[][] ranges = new int[n][2];
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            ranges[i][0] = Integer.parseInt(st.nextToken());
            ranges[i][1] = Integer.parseInt(st.nextToken());
        }

        int limit = 1 << n;
        int[] result = new int[n];
        boolean found = false;

        for (int i = 0; i < limit; ++i) {
            int count = 0;
            int[] selected = new int[p];

            for (int j = 0; j < n; ++j) {
                if ((i & (1 << j)) != 0) {
                    if (count < p) selected[count++] = j;
                }
            }

            if (count != p) continue;

            int minSum = 0, maxSum = 0;
            for (int idx : selected) {
                minSum += ranges[idx][0];
                maxSum += ranges[idx][1];
            }

            if (e < minSum || e > maxSum) continue;

            int remain = e - minSum;
            int[] temp = new int[n];

            for (int idx : selected) {
                temp[idx] = ranges[idx][0];
            }

            for (int idx : selected) {
                int extra = ranges[idx][1] - ranges[idx][0];
                int give = Math.min(extra, remain);
                temp[idx] += give;
                remain -= give;
                if (remain == 0) break;
            }

            result = temp;
            found = true;
            break;
        }

        if (found) {
            StringBuilder sb = new StringBuilder();
            for (int val : result) sb.append(val).append(" ");
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }
    }
}
