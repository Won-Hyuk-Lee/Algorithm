import java.io.*;

public class Main {
    static String S, T;
    static boolean found;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();
        dfs(T);
        System.out.println(found ? 1 : 0);
    }

    static void dfs(String str) {
        if (found) return;
        if (str.length() == S.length()) {
            if (str.equals(S)) found = true;
            return;
        }
        if (str.charAt(str.length() - 1) == 'A') dfs(str.substring(0, str.length() - 1));
        if (str.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder(str.substring(1));
            dfs(sb.reverse().toString());
        }
    }
}
