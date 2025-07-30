import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Queue<int[]> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                q.offer(new int[]{i, Integer.parseInt(st.nextToken())});
            }

            int count = 0;

            while (!q.isEmpty()) {
                int[] currentDoc = q.poll();
                boolean isMax = true;

                for (int[] docInQueue : q) {
                    if (docInQueue[1] > currentDoc[1]) {
                        isMax = false;
                        break;
                    }
                }

                if (isMax) {
                    count++;
                    if (currentDoc[0] == M) {
                        break;
                    }
                } else {
                    q.offer(currentDoc);
                }
            }
            sb.append(count).append('\n');
        }
        System.out.print(sb);
    }
}