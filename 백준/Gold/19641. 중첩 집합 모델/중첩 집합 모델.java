import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<ArrayList<Integer>> edges;
    static int[][] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        edges = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++) edges.add(new ArrayList<>());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            while (true) {
                int b = Integer.parseInt(st.nextToken());
                if (b == -1) break;
                edges.get(a).add(b);
            }
            Collections.sort(edges.get(a));
        }

        int S = Integer.parseInt(br.readLine());
        tree = new int[N + 1][2];
        dfs(S, 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) sb.append(i).append(" ").append(tree[i][0]).append(" ").append(tree[i][1]).append("\n");
        System.out.print(sb);
    }

    private static int dfs(int node, int n) {
        tree[node][0] = n;
        for (int next : edges.get(node)) {
            if (tree[next][0] == 0) n = dfs(next, n + 1);
        }
        tree[node][1] = n + 1;
        return n + 1;
    }
}
