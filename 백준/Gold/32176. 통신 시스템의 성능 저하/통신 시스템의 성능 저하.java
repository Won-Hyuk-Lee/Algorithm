import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static List<int[]> nodes = new ArrayList<>();
    static boolean[] check = new boolean[36];
    static int N, M, K1, K2;
    static int sX, sY, answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K1 = Integer.parseInt(st.nextToken());
        K2 = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; ++i) {
            String row = br.readLine();
            for (int j = 0; j < N; ++j) {
                char c = row.charAt(j);
                if (c == 'N') nodes.add(new int[]{i, j});
                else if (c == 'B') {
                    sX = i;
                    sY = j;
                }
            }
        }

        dfs(0, 0, M - K1, true);
        System.out.println(answer);
        answer = 0;
        dfs(0, 0, K2, false);
        System.out.println(answer);
    }

    static void dfs(int idx, int count, int limit, boolean isDay) {
        if (count == limit) {
            int p = 0, x1 = 10, y1 = 10, x2 = 0, y2 = 0;

            for (int i = 0; i < nodes.size(); ++i) {
                boolean selected = check[i];
                if ((isDay && !selected) || (!isDay && selected)) {
                    int[] node = nodes.get(i);
                    p += Math.abs(node[0] - sX) + Math.abs(node[1] - sY);
                    x1 = Math.min(x1, node[0]);
                    y1 = Math.min(y1, node[1]);
                    x2 = Math.max(x2, node[0]);
                    y2 = Math.max(y2, node[1]);
                }
            }

            int u = (x2 - x1 + 1) * (y2 - y1 + 1);
            int c = Math.max(p - u, 0);
            answer = Math.max(answer, c);
            return;
        }

        for (int i = idx; i < nodes.size(); ++i) {
            if (check[i]) continue;
            check[i] = true;
            dfs(i + 1, count + 1, limit, isDay);
            check[i] = false;
        }
    }
}
