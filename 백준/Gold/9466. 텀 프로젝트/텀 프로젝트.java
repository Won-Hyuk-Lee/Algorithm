import java.io.*;
import java.util.*;

public class Main {
    static int[] graph;
    static boolean[] visited, finished;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            graph = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) graph[i] = Integer.parseInt(st.nextToken());
            count = 0;
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) dfs(i);
            }
            System.out.println(n - count);
        }
    }

    static void dfs(int x) {
        visited[x] = true;
        int next = graph[x];
        if (!visited[next]) dfs(next);
        else if (!finished[next]) {
            for (int i = next; i != x; i = graph[i]) count++;
            count++;
        }
        finished[x] = true;
    }
}
