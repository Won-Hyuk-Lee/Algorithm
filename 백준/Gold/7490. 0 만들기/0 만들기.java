import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<String> res = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            res.clear();
            dfs(1, "1");
            Collections.sort(res);
            for (String s : res) System.out.println(s);
            System.out.println();
        }
    }

    static void dfs(int num, String expr) {
        if (num == N) {
            if (eval(expr.replace(" ", "")) == 0) res.add(expr);
            return;
        }
        dfs(num + 1, expr + " " + (num + 1));
        dfs(num + 1, expr + "+" + (num + 1));
        dfs(num + 1, expr + "-" + (num + 1));
    }

    static int eval(String expr) {
        int sum = 0, num = 0, sign = 1;
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (c == '+') {
                sum += sign * num;
                num = 0;
                sign = 1;
            } else if (c == '-') {
                sum += sign * num;
                num = 0;
                sign = -1;
            } else {
                num = num * 10 + (c - '0');
            }
        }
        return sum + sign * num;
    }
}
