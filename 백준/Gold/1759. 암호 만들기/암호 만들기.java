import java.io.*;
import java.util.*;

public class Main {
    static int L, C;
    static char[] input, comb;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] lc = br.readLine().split(" ");
        L = Integer.parseInt(lc[0]);
        C = Integer.parseInt(lc[1]);

        input = br.readLine().replace(" ", "").toCharArray();
        Arrays.sort(input);
        comb = new char[L];

        dfs(0, 0);
        bw.flush();
    }

    static void dfs(int idx, int depth) throws IOException {
        if (depth == L) {
            int mo = 0, ja = 0;
            for (char c : comb) {
                if ("aeiou".indexOf(c) >= 0) mo++;
                else ja++;
            }
            if (mo >= 1 && ja >= 2) bw.write(comb, 0, L);
            if (mo >= 1 && ja >= 2) bw.newLine();
            return;
        }

        for (int i = idx; i < C; i++) {
            comb[depth] = input[i];
            dfs(i + 1, depth + 1);
        }
    }
}
