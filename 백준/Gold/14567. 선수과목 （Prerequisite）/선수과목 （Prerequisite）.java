import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] indegree = new int[N + 1];
        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int pre = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            graph[pre].add(next);
            indegree[next]++;
        }

        int[] semester = new int[N + 1];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) q.offer(new int[]{i, 1});
        }

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int node = curr[0], sem = curr[1];
            semester[node] = sem;
            for (int next : graph[node]) {
                if (--indegree[next] == 0) q.offer(new int[]{next, sem + 1});
            }
        }

        StringBuilder sb = new StringBuilder(N * 2);
        for (int i = 1; i <= N; i++) sb.append(semester[i]).append(' ');
        System.out.println(sb);
    }
}
