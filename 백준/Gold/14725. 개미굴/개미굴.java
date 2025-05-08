import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        Map<String, Node> children = new TreeMap<>();
    }

    static void insert(Node root, String[] path) {
        Node cur = root;
        for (String s : path) {
            cur = cur.children.computeIfAbsent(s, k -> new Node());
        }
    }

    static void dfs(Node node, int depth, BufferedWriter bw) throws IOException {
        for (String key : node.children.keySet()) {
            for (int i = 0; i < depth; i++) bw.write("--");
            bw.write(key); bw.newLine();
            dfs(node.children.get(key), depth + 1, bw);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int k = Integer.parseInt(input[0]);
            String[] path = Arrays.copyOfRange(input, 1, k + 1);
            insert(root, path);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        dfs(root, 0, bw);
        bw.flush();
    }
}
