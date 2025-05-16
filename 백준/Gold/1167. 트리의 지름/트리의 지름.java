import java.util.*;

public class Main {
    static List<int[]>[] graph;
    static boolean[] visited;
    static int maxDist, farNode;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            int from = sc.nextInt();
            while (true) {
                int to = sc.nextInt();
                if (to == -1) break;
                int weight = sc.nextInt();
                graph[from].add(new int[]{to, weight});
            }
        }

        visited = new boolean[V + 1];
        dfs(1, 0);
        visited = new boolean[V + 1];
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
        for (int[] edge : graph[node]) {
            if (!visited[edge[0]])
                dfs(edge[0], dist + edge[1]);
        }
    }
}
