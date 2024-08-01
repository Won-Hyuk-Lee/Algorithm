import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<List<Integer>> graph;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        graph = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        //DP초기화 얼리 어답터가 아닐 때, 얼리 어답터일 때로
        dp = new int[2][N + 1];

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        //루트노드를 1로 가정한 dfs 실행
        dfs(1, 0);

        System.out.println(Math.min(dp[0][1], dp[1][1]));
    }

    static void dfs(int current, int parent) {
        //얼리 어답터X
        dp[0][current] = 0;
        //얼리 어답터O
        dp[1][current] = 1;

        for (int child : graph.get(current)) {
            if (child != parent) { //부모노드로 못가게
                dfs(child, current);
                
                //현재 노드가 얼리 어답터가 아니면 모든 자식은 얼리 어답터임
                dp[0][current] += dp[1][child];
                
                //현재 노드가 얼리 어답터면 자식은 얼리 어답터일 수도 있고 아닐 수도 있음
                dp[1][current] += Math.min(dp[0][child], dp[1][child]);
            }
        }
    }
}