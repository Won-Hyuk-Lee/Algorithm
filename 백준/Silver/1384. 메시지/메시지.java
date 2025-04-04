import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int group = 1;

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            String[] names = new String[n];
            String[][] rel = new String[n][n - 1];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                names[i] = st.nextToken();
                for (int j = 0; j < n - 1; j++) {
                    rel[i][j] = st.nextToken();
                }
            }

            sb.append("Group ").append(group++).append("\n");
            boolean found = false;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (rel[i][j].equals("N")) {
                        int from = (i - j - 1 + n) % n;
                        sb.append(names[from]).append(" was nasty about ").append(names[i]).append("\n");
                        found = true;
                    }
                }
            }

            if (!found) sb.append("Nobody was nasty\n");
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
