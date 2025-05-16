import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static boolean[] used;
    static int[] out;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int d) {
        if (d == M) {
            for (int i = 0; i < M; i++) {
                sb.append(out[i]).append(' ');
            }
            sb.append('\n');
            return;
        }
        int prev = 0;
        for (int i = 0; i < N; i++) {
            if (used[i] || arr[i] == prev) continue;
            used[i] = true;
            out[d] = arr[i];
            prev = arr[i];
            dfs(d+1);
            used[i] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        used = new boolean[N];
        out = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        dfs(0);
        System.out.print(sb);
    }
}
