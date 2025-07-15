import java.io.*;
import java.util.*;

class Info implements Comparable<Info> {
    int col, count;

    Info(int col, int count) {
        this.col = col;
        this.count = count;
    }

    @Override
    public int compareTo(Info o) {
        return Integer.compare(o.count, this.count);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] result = new int[n][n];

        StringTokenizer rowToken = new StringTokenizer(br.readLine());
        StringTokenizer colToken = new StringTokenizer(br.readLine());

        PriorityQueue<Info> pq = new PriorityQueue<>();
        for (int j = 0; j < n; j++) {
            int c = Integer.parseInt(colToken.nextToken());
            if (c > 0) pq.add(new Info(j, c));
        }

        boolean possible = true;

        for (int i = 0; i < n; i++) {
            int r = Integer.parseInt(rowToken.nextToken());
            if (r == 0) continue;

            if (pq.size() < r) {
                possible = false;
                break;
            }

            List<Info> temp = new ArrayList<>();
            for (int k = 0; k < r; k++) {
                Info info = pq.poll();
                result[i][info.col] = 1;
                if (--info.count > 0) temp.add(info);
            }

            pq.addAll(temp);
        }

        if (!possible || !pq.isEmpty()) {
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder("1\n");
        for (int[] row : result) {
            for (int val : row) sb.append(val);
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
