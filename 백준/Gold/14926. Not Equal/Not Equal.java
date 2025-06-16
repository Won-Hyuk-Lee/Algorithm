import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] crossed = new boolean[N + 1][N + 1];
        int curVertex = 0;
        StringBuilder sb = new StringBuilder();

        crossed[1][N] = crossed[N][1] = true;

        int totalEdges = (N * (N - 1)) / 2;
        for (int i = 0; i < totalEdges; i++) {
            for (int vertex = 1; vertex <= N; vertex++) {
                if (vertex == curVertex || crossed[curVertex][vertex]) continue;
                crossed[curVertex][vertex] = crossed[vertex][curVertex] = true;
                curVertex = vertex;
                break;
            }
            sb.append("a").append(curVertex).append(" ");
        }

        sb.append("a1");
        System.out.println(sb);
    }
}
