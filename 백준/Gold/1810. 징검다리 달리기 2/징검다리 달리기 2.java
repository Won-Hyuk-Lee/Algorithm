import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        long key;
        double dist;
        Node(long key, double dist) { this.key = key; this.dist = dist; }
        public int compareTo(Node o) { return Double.compare(this.dist, o.dist); }
    }
    static int gcd(int a, int b) {
        return b == 0 ? Math.abs(a) : gcd(b, a % b);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), F = Integer.parseInt(st.nextToken());
        Set<Long> coords = new HashSet<>(N+1);
        Map<Long, Double> dist = new HashMap<>(N+1);
        long startKey = 0L;
        coords.add(startKey);
        dist.put(startKey, 0.0);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()), x = Integer.parseInt(st.nextToken());
            long key = ((long)y << 32) | (x & 0xffffffffL);
            coords.add(key);
            dist.put(key, Double.POSITIVE_INFINITY);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(startKey, 0.0));
        double ans = Double.POSITIVE_INFINITY;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.dist > dist.get(cur.key)) continue;
            int cy = (int)(cur.key >> 32), cx = (int)cur.key;
            if (cx == F) { ans = cur.dist; break; }
            for (int dy = -2; dy <= 2; dy++) {
                for (int dx = -2; dx <= 2; dx++) {
                    if (dy == 0 && dx == 0) continue;
                    int ny = cy + dy, nx = cx + dx;
                    long nk = ((long)ny << 32) | (nx & 0xffffffffL);
                    if (!coords.contains(nk)) continue;
                    double nd = cur.dist + Math.hypot(dy, dx);
                    if (nd < dist.get(nk)) {
                        dist.put(nk, nd);
                        pq.add(new Node(nk, nd));
                    }
                }
            }
        }
        if (Double.isInfinite(ans)) System.out.print(-1);
        else System.out.print((long)Math.round(ans));
    }
}
