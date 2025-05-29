import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] kit = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            kit[i] = Integer.parseInt(st.nextToken()) - K;
        }

        backtrack(0, 0, N, new boolean[N], kit);
        System.out.println(cnt);
    }

    private static void backtrack(int depth, int sum, int N, boolean[] visited, int[] kit) {
        if (depth == N) {
            cnt++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i] && sum + kit[i] >= 0) {
                visited[i] = true;
                backtrack(depth + 1, sum + kit[i], N, visited, kit);
                visited[i] = false;
            }
        }
    }
}
