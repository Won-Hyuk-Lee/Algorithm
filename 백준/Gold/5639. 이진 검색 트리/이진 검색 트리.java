import java.io.*;

public class Main {
    static int[] nodes = new int[10001];
    static int idx = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            nodes[idx++] = Integer.parseInt(line);
        }
        postOrder(0, idx - 1);
        System.out.print(sb);
    }

    static void postOrder(int start, int end) {
        if (start > end) return;
        int root = nodes[start];
        int mid = start + 1;
        while (mid <= end && nodes[mid] < root) mid++;
        postOrder(start + 1, mid - 1);
        postOrder(mid, end);
        sb.append(root).append('\n');
    }
}
