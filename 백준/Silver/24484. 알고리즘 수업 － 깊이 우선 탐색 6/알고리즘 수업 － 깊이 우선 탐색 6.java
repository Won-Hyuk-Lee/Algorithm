import java.io.*;
import java.util.*;

public class Main {
    static long sum;
    static int visitOrder;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeNum = Integer.parseInt(st.nextToken());
        int edgeNum = Integer.parseInt(st.nextToken());
        int startNodeNum = Integer.parseInt(st.nextToken());

        List<Integer>[] edges = new ArrayList[nodeNum + 1];
        for (int i = 1; i <= nodeNum; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < edgeNum; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges[a].add(b);
            edges[b].add(a);
        }

        for (int i = 1; i <= nodeNum; i++) {
            edges[i].sort(Comparator.reverseOrder());
        }

        boolean[] visited = new boolean[nodeNum + 1];
        dfs(edges, visited, startNodeNum, 0);

        System.out.println(sum);
    }

    static void dfs(List<Integer>[] edges, boolean[] visited, int curNode, long depth) {
        visited[curNode] = true;
        sum += (++visitOrder) * depth;

        for (int next : edges[curNode]) {
            if (!visited[next]) {
                dfs(edges, visited, next, depth + 1);
            }
        }
    }
}
