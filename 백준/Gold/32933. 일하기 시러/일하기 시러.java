import java.io.*;
import java.util.*;

public class Main {
    static class Fruit { int grow, regrow, value; }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        Fruit[] f = new Fruit[K+1];
        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            Fruit x = new Fruit();
            x.grow = Integer.parseInt(st.nextToken());
            x.regrow = Integer.parseInt(st.nextToken());
            x.value = Integer.parseInt(st.nextToken());
            f[i] = x;
        }
        int maxR = M;
        int[][] cur = new int[K+1][maxR+1];
        int[][] nxt = new int[K+1][maxR+1];
        for (int i = 0; i <= K; i++) Arrays.fill(cur[i], -1);
        cur[0][0] = 0;
        for (int day = 0; day < M; day++) {
            for (int i = 0; i <= K; i++) Arrays.fill(nxt[i], -1);
            for (int i = 0; i <= K; i++) {
                for (int r = 0; r <= maxR; r++) {
                    int p = cur[i][r];
                    if (p < 0) continue;
                    if (p > nxt[i][r]) nxt[i][r] = p;
                    for (int j = 1; j <= K; j++) {
                        int pd = day + f[j].grow;
                        if (pd <= M && p > nxt[j][pd]) nxt[j][pd] = p;
                    }
                    if (i > 0 && r <= day) {
                        int hp = p + f[i].value;
                        int rd = day + f[i].regrow;
                        if (rd <= M) {
                            if (hp > nxt[i][rd]) nxt[i][rd] = hp;
                        } else {
                            if (hp > nxt[0][0]) nxt[0][0] = hp;
                        }
                        for (int j = 1; j <= K; j++) {
                            int npd = day + f[j].grow;
                            if (npd <= M && hp > nxt[j][npd]) nxt[j][npd] = hp;
                        }
                    }
                }
            }
            int[][] tmp = cur;
            cur = nxt;
            nxt = tmp;
        }
        int best = 0;
        for (int i = 0; i <= K; i++) {
            for (int r = 0; r <= maxR; r++) {
                if (cur[i][r] > best) best = cur[i][r];
                if (i > 0 && cur[i][r] >= 0) {
                    int hp = cur[i][r] + f[i].value;
                    if (hp > best) best = hp;
                }
            }
        }
        System.out.println((long)best * N);
    }
}
