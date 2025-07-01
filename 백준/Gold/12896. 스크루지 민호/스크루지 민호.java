import java.io.*;
import java.util.*;

public class Main {
    static int n, max, node;
    static ArrayList<Node>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) list[i] = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list[s].add(new Node(e, 1));
            list[e].add(new Node(s, 1));
        }
        max = -1;
        visited = new boolean[n + 1];
        dfs(1, 0);

        max = -1;
        visited = new boolean[n + 1];
        dfs(node, 0);

        System.out.println((1 + max) / 2);
    }

    static void dfs(int x, int len) {
        visited[x] = true;
        if (max < len) {
            max = len;
            node = x;
        }
        for (Node next : list[x]) {
            if (!visited[next.end]) {
                dfs(next.end, len + next.cost);
            }
        }
    }

    static class Node {
        int end, cost;
        Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
}
