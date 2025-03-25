import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int k = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        char[] startChar = new char[k];
        for (int i = 0; i < k; i++) {
            startChar[i] = (char) ('A' + i);
        }

        char[] destinationChar = br.readLine().toCharArray();
        char[][] map = new char[n][];
        int unknownIdx = 0;

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
            if (map[i][0] == '?') unknownIdx = i;
        }

        for (int i = 0; i < unknownIdx; i++) {
            for (int j = 0; j < k - 1; j++) {
                if (map[i][j] == '-') {
                    char tmp = startChar[j];
                    startChar[j] = startChar[j + 1];
                    startChar[j + 1] = tmp;
                }
            }
        }

        for (int i = n - 1; i > unknownIdx; i--) {
            for (int j = 0; j < k - 1; j++) {
                if (map[i][j] == '-') {
                    char tmp = destinationChar[j];
                    destinationChar[j] = destinationChar[j + 1];
                    destinationChar[j + 1] = tmp;
                }
            }
        }

        for (int i = 0; i < k - 1; i++) {
            if (startChar[i] == destinationChar[i]) {
                sb.append("*");
            } else if (startChar[i] == destinationChar[i + 1] && startChar[i + 1] == destinationChar[i]) {
                sb.append("-");
                char tmp = startChar[i];
                startChar[i] = startChar[i + 1];
                startChar[i + 1] = tmp;
            } else {
                System.out.println("x".repeat(k - 1));
                return;
            }
        }

        System.out.println(sb);
    }
}
