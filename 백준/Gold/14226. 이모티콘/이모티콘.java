import java.util.*;

public class Main {

    static boolean[][] visited = new boolean[1001][1001];

    public static void main(String[] args) {
        int s = new Scanner(System.in).nextInt();
        bfs(s);
    }

    public static void bfs(int s) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 1, 0));
        visited[0][1] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.total == s) {
                System.out.println(cur.time);
                return;
            }

            if (!visited[cur.total][cur.total]) {
                visited[cur.total][cur.total] = true;
                q.offer(new Node(cur.total, cur.total, cur.time + 1));
            }

            int pasted = cur.total + cur.clipboard;
            if (cur.clipboard > 0 && pasted <= s && !visited[cur.clipboard][pasted]) {
                visited[cur.clipboard][pasted] = true;
                q.offer(new Node(cur.clipboard, pasted, cur.time + 1));
            }

            int deleted = cur.total - 1;
            if (deleted >= 0 && !visited[cur.clipboard][deleted]) {
                visited[cur.clipboard][deleted] = true;
                q.offer(new Node(cur.clipboard, deleted, cur.time + 1));
            }
        }
    }

    static class Node {
        int clipboard, total, time;
        Node(int clipboard, int total, int time) {
            this.clipboard = clipboard;
            this.total = total;
            this.time = time;
        }
    }
}
