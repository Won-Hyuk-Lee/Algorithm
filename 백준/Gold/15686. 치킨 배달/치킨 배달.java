import java.io.*;
import java.util.*;

public class Main {
    static List<int[]> homes = new ArrayList<>();
    static List<int[]> chickens = new ArrayList<>();
    static int M, min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 1) homes.add(new int[]{i, j});
                else if (val == 2) chickens.add(new int[]{i, j});
            }
        }

        combine(0, 0, new boolean[chickens.size()]);
        System.out.println(min);
    }

    static void combine(int idx, int count, boolean[] sel) {
        if (count == M) {
            int sum = 0;
            for (int[] h : homes) {
                int dist = Integer.MAX_VALUE;
                for (int i = 0; i < chickens.size(); i++) {
                    if (sel[i]) {
                        int[] c = chickens.get(i);
                        dist = Math.min(dist, Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]));
                    }
                }
                sum += dist;
            }
            min = Math.min(min, sum);
            return;
        }
        if (idx == chickens.size()) return;

        sel[idx] = true;
        combine(idx + 1, count + 1, sel);
        sel[idx] = false;
        combine(idx + 1, count, sel);
    }
}
