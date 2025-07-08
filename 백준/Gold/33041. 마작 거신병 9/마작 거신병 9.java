import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int H = Integer.parseInt(br.readLine());
        int[] W = new int[H];
        int[] v = new int[H];
        int[] vsum = new int[H];

        String[] wInput = br.readLine().split(" ");
        for (int i = 0; i < H; i++) {
            W[i] = Integer.parseInt(wInput[i]);
            vsum[i] = W[i];
        }

        String[] cd = br.readLine().split(" ");
        int C = Integer.parseInt(cd[0]);
        int D = Integer.parseInt(cd[1]);

        for (int i = 1; i < H; i++) {
            int cnt = 0;
            while (vsum[i - 1] >= vsum[i] + cnt * 8 && cnt <= W[i]) {
                cnt++;
            }
            vsum[i] += cnt * 8;
            v[i] += cnt;
            D -= cnt;
        }

        if (D < 0) {
            bw.write("-1\n");
            bw.flush();
            return;
        }

        while (W[H - 1] > v[H - 1] && D > 0) {
            v[H - 1]++;
            D--;
            vsum[H - 1] += 8;
        }

        for (int i = H - 2; i >= 0; i--) {
            if (D == 0) break;
            while (W[i] > v[i] && D > 0 && vsum[i] + 8 < vsum[i + 1]) {
                v[i]++;
                D--;
                vsum[i] += 8;
            }
        }

        if (D > 0) {
            bw.write("-1\n");
            bw.flush();
            return;
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < v[i]; j++) {
                bw.write("9 ");
            }
            for (int j = 0; j < W[i] - v[i]; j++) {
                bw.write("1 ");
            }
            bw.write("\n");
        }

        bw.flush();
    }
}
