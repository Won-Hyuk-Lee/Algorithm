import java.io.*;
import java.util.*;

public class Main {
    static int[] left = new int[26], right = new int[26];
    static StringBuilder sb = new StringBuilder();
    static void pre(int u) {
        if (u < 0) return;
        sb.append((char)(u + 'A'));
        pre(left[u]); pre(right[u]);
    }
    static void in(int u) {
        if (u < 0) return;
        in(left[u]);
        sb.append((char)(u + 'A'));
        in(right[u]);
    }
    static void post(int u) {
        if (u < 0) return;
        post(left[u]); post(right[u]);
        sb.append((char)(u + 'A'));
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Arrays.fill(left, -1);
        Arrays.fill(right, -1);
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = st.nextToken().charAt(0) - 'A';
            char l = st.nextToken().charAt(0), r = st.nextToken().charAt(0);
            left[p] = l == '.' ? -1 : l - 'A';
            right[p] = r == '.' ? -1 : r - 'A';
        }
        pre(0); sb.append('\n');
        in(0); sb.append('\n');
        post(0);
        System.out.print(sb);
    }
}
