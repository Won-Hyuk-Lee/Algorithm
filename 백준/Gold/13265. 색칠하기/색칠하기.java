import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            ArrayList<Integer>[] graph = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }

            int[] color = new int[n + 1];
            boolean isPossible = true;

            for (int i = 1; i <= n && isPossible; i++) {
                if (color[i] == 0) {
                    isPossible = bfs(graph, color, i);
                }
            }

            sb.append(isPossible ? "possible" : "impossible").append("\n");
        }

        System.out.print(sb);
    }

    private static boolean bfs(ArrayList<Integer>[] graph, int[] color, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph[cur]) {
                if (color[next] == 0) {
                    color[next] = -color[cur];
                    q.add(next);
                } else if (color[next] == color[cur]) {
                    return false;
                }
            }
        }
        return true;
    }
}
