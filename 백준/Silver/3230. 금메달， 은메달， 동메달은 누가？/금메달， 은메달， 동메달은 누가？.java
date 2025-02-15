import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] rank1 = new int[n + 1];
        int perRank;

        for (int i = 1; i <= n; i++) {
            perRank = Integer.parseInt(br.readLine());
            if (rank1[perRank] != 0) {
                System.arraycopy(rank1, perRank, rank1, perRank + 1, i - perRank);
            }
            rank1[perRank] = i;
        }

        int[] rank2 = new int[m + 1];
        for (int i = 1, m2 = m; i <= m2; i++, m--) {
            perRank = Integer.parseInt(br.readLine());
            if (rank2[perRank] != 0) {
                System.arraycopy(rank2, perRank, rank2, perRank + 1, i - perRank);
            }
            rank2[perRank] = rank1[m];
        }

        System.out.println(rank2[1] + "\n" + rank2[2] + "\n" + rank2[3]);
    }
}
