import java.io.*;
import java.util.*;

public class Main {
    static int N, M, R, count = 1;
    static int[] result;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        result = new int[N + 1];
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 1; i <= N; i++) Collections.sort(graph.get(i), Collections.reverseOrder());

        dfs(R);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) sb.append(result[i]).append("\n");
        System.out.print(sb);

        br.close();
    }

    static void dfs(int cur) {
        result[cur] = count++;
        for (int next : graph.get(cur)) {
            if (result[next] == 0) dfs(next);
        }
    }
}
