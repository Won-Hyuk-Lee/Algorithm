import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int to, cost;
        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static int N, X;
    static List<Node>[] graph, reverse;
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        reverse = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            reverse[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, c));
            reverse[v].add(new Node(u, c));
        }

        int[] distToX = dijkstra(reverse, X);
        int[] distFromX = dijkstra(graph, X);

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, distToX[i] + distFromX[i]);
        }

        System.out.println(max);
    }

    static int[] dijkstra(List<Node>[] g, int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.cost > dist[cur.to]) continue;
            for (Node next : g[cur.to]) {
                int cost = cur.cost + next.cost;
                if (dist[next.to] > cost) {
                    dist[next.to] = cost;
                    pq.add(new Node(next.to, cost));
                }
            }
        }
        return dist;
    }
}
