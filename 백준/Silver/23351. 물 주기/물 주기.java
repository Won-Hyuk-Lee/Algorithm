import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] pots = new int[n];
        Arrays.fill(pots, k);

        int day = 0, idx = 0;
        while (true) {
            for (int i = 0; i < a; i++) {
                pots[(idx + i) % n] += b;
            }
            for (int i = 0; i < n; i++) {
                if (--pots[i] == 0) {
                    System.out.println(++day);
                    return;
                }
            }
            idx = (idx + a) % n;
            day++;
        }
    }
}
