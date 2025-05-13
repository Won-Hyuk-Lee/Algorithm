import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        boolean[] know = new boolean[N + 1];
        if (T > 0) {
            while (T-- > 0) know[Integer.parseInt(st.nextToken())] = true;
        }
        List<Integer>[] parties = new ArrayList[M];
        for (int i = 0; i < M; i++) parties[i] = new ArrayList<>();
        int[][] parent = new int[N + 1][1];
        for (int i = 1; i <= N; i++) parent[i][0] = i;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            int first = Integer.parseInt(st.nextToken());
            parties[i].add(first);
            for (int j = 1; j < cnt; j++) {
                int next = Integer.parseInt(st.nextToken());
                parties[i].add(next);
                union(parent, first, next);
            }
        }

        boolean[] groupKnow = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if (know[i]) groupKnow[find(parent, i)] = true;
        }

        int res = 0;
        for (List<Integer> party : parties) {
            boolean canLie = true;
            for (int person : party) {
                if (groupKnow[find(parent, person)]) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) res++;
        }
        System.out.println(res);
    }

    static int find(int[][] parent, int x) {
        if (parent[x][0] != x) parent[x][0] = find(parent, parent[x][0]);
        return parent[x][0];
    }

    static void union(int[][] parent, int a, int b) {
        a = find(parent, a);
        b = find(parent, b);
        if (a != b) parent[b][0] = a;
    }
}
