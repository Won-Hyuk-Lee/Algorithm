import java.util.*;
import java.io.*;

public class Main {
    static int vertexCount, edgeCount, startVertex;
    static List<Edge>[] graph;
    static int[] distances;

    static class Edge implements Comparable<Edge> {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        vertexCount = Integer.parseInt(st.nextToken());
        edgeCount = Integer.parseInt(st.nextToken());
        startVertex = Integer.parseInt(br.readLine());

        //그래프 초기화
        graph = new ArrayList[vertexCount + 1];
        for (int i = 1; i <= vertexCount; i++) {
            graph[i] = new ArrayList<>();
        }

        //간선 정보 입력
        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[from].add(new Edge(to, weight));
        }

        //다익스트라 실행
        distances = dijkstra(startVertex);

        //결과
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= vertexCount; i++) {
            sb.append(distances[i] == Integer.MAX_VALUE ? "INF" : distances[i]).append('\n');
        }
        System.out.print(sb);
    }

    //다익스트라 구현
    static int[] dijkstra(int start) {
        
        //거리 배열 초기화
        int[] dist = new int[vertexCount + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        //우선순위 큐를 이용해서 다익스트라
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int vertex = current.to;
            int weight = current.weight;

            //이미 처리된 정점은 스킵한다
            if (dist[vertex] < weight) continue;

            for (Edge next : graph[vertex]) {
                int newDistance = weight + next.weight;
                if (newDistance < dist[next.to]) {
                    dist[next.to] = newDistance;
                    pq.offer(new Edge(next.to, newDistance));
                }
            }
        }
        return dist;
    }
}