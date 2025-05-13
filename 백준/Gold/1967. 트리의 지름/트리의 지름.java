import java.io.*;
import java.util.*;

public class Main {
    static List<int[]>[] tree;
    static boolean[] visited;
    static int maxDist = 0, farNode = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n == 1) {
            System.out.println(0);
            return;
        }

        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) tree[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            tree[parent].add(new int[]{child, cost});
            tree[child].add(new int[]{parent, cost});
        }

        visited = new boolean[n + 1];
        dfs(1, 0);

        visited = new boolean[n + 1];
        maxDist = 0;
        dfs(farNode, 0);

        System.out.println(maxDist);
    }

    static void dfs(int node, int dist) {
        visited[node] = true;
        if (dist > maxDist) {
            maxDist = dist;
            farNode = node;
        }
        for (int[] next : tree[node]) {
            if (!visited[next[0]]) {
                dfs(next[0], dist + next[1]);
            }
        }
    }
}
