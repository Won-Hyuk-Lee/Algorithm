import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] time = new int[100001];
        Arrays.fill(time, -1);
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(N);
        time[N] = 0;

        while (!dq.isEmpty()) {
            int cur = dq.poll();
            if (cur * 2 <= 100000 && time[cur * 2] == -1) {
                time[cur * 2] = time[cur];
                dq.addFirst(cur * 2);
            }
            if (cur - 1 >= 0 && time[cur - 1] == -1) {
                time[cur - 1] = time[cur] + 1;
                dq.addLast(cur - 1);
            }
            if (cur + 1 <= 100000 && time[cur + 1] == -1) {
                time[cur + 1] = time[cur] + 1;
                dq.addLast(cur + 1);
            }
        }
        System.out.println(time[K]);
    }
}