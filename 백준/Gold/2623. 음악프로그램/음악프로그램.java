import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        int[] inDegree = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int[] seq = new int[k];
            for (int j = 0; j < k; j++) seq[j] = Integer.parseInt(st.nextToken());
            for (int j = 0; j < k - 1; j++) {
                graph[seq[j]].add(seq[j + 1]);
                inDegree[seq[j + 1]]++;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) if (inDegree[i] == 0) q.add(i);

        List<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            int cur = q.poll();
            result.add(cur);
            for (int next : graph[cur]) {
                if (--inDegree[next] == 0) q.add(next);
            }
        }

        if (result.size() != N) System.out.println(0);
        else for (int x : result) System.out.println(x);
    }
}
