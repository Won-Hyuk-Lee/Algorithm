import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 1024;  //최대 정점
    static final int LOG = 11;   //최대 깊이에 대한 로그
    static int[] depth = new int[MAX]; //각 정점 깊이
    static int[][] parent = new int[MAX][LOG]; //부모

    // 트리 초기화 및 깊이 계산
    static void dfs(int node, int d) {
        depth[node] = d;
        int child = node * 2; //왼쪽 자식
        if (child >= MAX) return;

        parent[child][0] = node; //왼쪽 자식 부모
        dfs(child, d + 1);

        if (child + 1 < MAX) {  //오른쪽 자식
            parent[child + 1][0] = node;
            dfs(child + 1, d + 1);
        }
    }

    static void init() {
        dfs(1, 0); //루트 노드부터 깊이탐색
        for (int j = 1; j < LOG; j++) {
            for (int i = 1; i < MAX; i++) {
                parent[i][j] = parent[parent[i][j - 1]][j - 1];
            }
        }
    }

    //LCA 계산
    static int lca(int u, int v) {
        if (depth[u] > depth[v]) { //깊이 맞추기
            int temp = u;
            u = v;
            v = temp;
        }

        for (int i = LOG - 1; i >= 0; i--) {
            if (depth[v] - depth[u] >= (1 << i)) {
                v = parent[v][i];
            }
        }

        if (u == v) return u; //공통 조상 발견

        for (int i = LOG - 1; i >= 0; i--) {
            if (parent[u][i] != parent[v][i]) {
                u = parent[u][i];
                v = parent[v][i];
            }
        }

        return parent[u][0]; //최종 공통 부모 반환
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        init(); //트리 초기화

        int testCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            int commonParent = lca(u, v); //공통 조상 찾기
            bw.write(commonParent * 10 + "\n");
        }

        bw.flush();
        bw.close();
    }
}
