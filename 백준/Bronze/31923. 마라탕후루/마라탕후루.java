import java.io.*;
import java.util.*;

public class Main {
    static int p, q;
    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        count = new int[n];

        int[] strawberry = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            strawberry[i] = Integer.parseInt(st.nextToken());
        }

        int[] muscat = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            muscat[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            if (!canEqualize(strawberry[i], muscat[i], i)) {
                sb.append("NO");
                bw.write(sb.toString());
                bw.flush();
                bw.close();
                br.close();
                return;
            }
        }

        sb.append("YES\n");
        for (int num : count) {
            sb.append(num).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean canEqualize(int s, int m, int index) {
        if (p == q) return s == m;
        if (s == m) return true;

        int num = 0;
        while ((p > q && s < m) || (p < q && s > m)) {
            num++;
            s += p;
            m += q;
            if (s == m) {
                count[index] = num;
                return true;
            }
        }
        return false;
    }
}