import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int a = 0, b = n - 1;
        int c = 3 * n - 3, d = 4 * n - 4;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < 2 * n; i++) {
            if (i == 1 || i == (2 * n) - 1) {
                sb.append("*".repeat(n)); 
                sb.append(" ".repeat(2 * n - 3));
                sb.append("*".repeat(n));
            } else {  
                sb.append(" ".repeat(a)).append("*");
                sb.append(" ".repeat(n - 2)).append("*");

                if (b != c) sb.append(" ".repeat(c - b - 1)).append("*");

                sb.append(" ".repeat(n - 2)).append("*");
            }
            sb.append("\n");

            if (i < n) {
                a++; b++; c--; d--;
            } else {
                a--; b--; c++; d++;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
