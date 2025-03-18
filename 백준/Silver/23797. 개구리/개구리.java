import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();

        int startP = 0, startK = 0, pIdx = 0, kIdx = 0;

        for (char c : input) {
            if (c == 'P') {
                if (kIdx > 0) kIdx--;
                else pIdx++;
            } else {
                if (pIdx > 0) pIdx--;
                else kIdx++;
            }
            startP = Math.max(startP, pIdx);
            startK = Math.max(startK, kIdx);
        }

        System.out.println(startP + startK);
    }
}