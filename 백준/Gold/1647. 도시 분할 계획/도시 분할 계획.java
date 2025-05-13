import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) parent[i] = i;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        int sum = 0, max = 0;
        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            if (union(edge[0], edge[1])) {
                sum += edge[2];
                max = edge[2];
            }
        }

        System.out.println(sum - max);
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return false;
        parent[b] = a;
        return true;
    }
}
