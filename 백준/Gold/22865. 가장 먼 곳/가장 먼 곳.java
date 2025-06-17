import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static ArrayList<Node>[] graph;

    static class Node implements Comparable<Node> {
        int to;
        long cost;
        Node(int to, long cost) {
            this.to = to;
            this.cost = cost;
        }
        public int compareTo(Node o) {
            return Long.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(in.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(in.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(in.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, cost));
            graph[v].add(new Node(u, cost));
        }

        long[] d1 = dijkstra(a);
        long[] d2 = dijkstra(b);
        long[] d3 = dijkstra(c);

        int ans = 0;
        long max = -1;
        for (int i = 1; i <= n; i++) {
            long min = Math.min(d1[i], Math.min(d2[i], d3[i]));
            if (min > max) {
                max = min;
                ans = i;
            }
        }
        System.out.println(ans);
    }

    static long[] dijkstra(int start) {
        long[] dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (dist[cur.to] < cur.cost) continue;
            for (Node next : graph[cur.to]) {
                long newCost = cur.cost + next.cost;
                if (dist[next.to] > newCost) {
                    dist[next.to] = newCost;
                    pq.add(new Node(next.to, newCost));
                }
            }
        }
        return dist;
    }
}
