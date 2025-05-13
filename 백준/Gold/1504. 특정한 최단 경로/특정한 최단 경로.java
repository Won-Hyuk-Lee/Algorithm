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

    static int N, E;
    static List<Node>[] graph;
    static final int INF = 200000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, c));
            graph[v].add(new Node(u, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int[] d1 = dijkstra(1);
        int[] dV1 = dijkstra(v1);
        int[] dV2 = dijkstra(v2);

        int route1 = safeAdd(d1[v1], dV1[v2], dV2[N]);
        int route2 = safeAdd(d1[v2], dV2[v1], dV1[N]);

        int res = Math.min(route1, route2);
        System.out.println(res >= INF ? -1 : res);
    }

    static int[] dijkstra(int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.cost > dist[cur.to]) continue;
            for (Node next : graph[cur.to]) {
                int newCost = cur.cost + next.cost;
                if (dist[next.to] > newCost) {
                    dist[next.to] = newCost;
                    pq.add(new Node(next.to, newCost));
                }
            }
        }

        return dist;
    }

    static int safeAdd(int a, int b, int c) {
        if (a >= INF || b >= INF || c >= INF) return INF;
        return a + b + c;
    }
}
