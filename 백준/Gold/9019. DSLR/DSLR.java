import java.io.*;
import java.util.*;

class Main {
    static boolean[] visited = new boolean[10000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            Arrays.fill(visited, false);
            Queue<Node> q = new LinkedList<>();
            q.add(new Node(A, ""));
            visited[A] = true;

            while (!q.isEmpty()) {
                Node cur = q.poll();
                if (cur.num == B) {
                    sb.append(cur.cmd).append('\n');
                    break;
                }

                int d = (cur.num * 2) % 10000;
                int s = (cur.num == 0) ? 9999 : cur.num - 1;
                int l = (cur.num % 1000) * 10 + (cur.num / 1000);
                int r = (cur.num % 10) * 1000 + (cur.num / 10);

                if (!visited[d]) { visited[d] = true; q.add(new Node(d, cur.cmd + "D")); }
                if (!visited[s]) { visited[s] = true; q.add(new Node(s, cur.cmd + "S")); }
                if (!visited[l]) { visited[l] = true; q.add(new Node(l, cur.cmd + "L")); }
                if (!visited[r]) { visited[r] = true; q.add(new Node(r, cur.cmd + "R")); }
            }
        }
        System.out.print(sb);
    }

    static class Node {
        int num;
        String cmd;
        Node(int num, String cmd) {
            this.num = num;
            this.cmd = cmd;
        }
    }
}
