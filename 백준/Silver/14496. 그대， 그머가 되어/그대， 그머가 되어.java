import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int NOT_FOUND = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int startNode = Integer.parseInt(st.nextToken());
        int targetNode = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int nodeCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new LinkedList[nodeCount + 1];
        for (int i = 0; i <= nodeCount; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        int result = bfs(graph, startNode, targetNode, nodeCount);
        System.out.println(result);
    }

    private static int bfs(List<Integer>[] graph, int start, int target, int nodeCount) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[nodeCount + 1];
        queue.offer(start);
        visited[start] = true;
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                if (current == target) {
                    return steps;
                }
                for (int next : graph[current]) {
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
            steps++;
        }

        return NOT_FOUND;
    }
}
