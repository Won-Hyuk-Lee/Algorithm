import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int SIZE = 4;
        int answer = 0;

        for (int i = 0; i < SIZE; i++) {
            String input = br.readLine();
            for (int j = 0; j < SIZE; j++) {
                char current = input.charAt(j);
                if (current == '.') continue;

                int number = current - 'A';
                answer += Math.abs(i - number / SIZE) + Math.abs(j - number % SIZE);
            }
        }

        System.out.println(answer);
        br.close();
    }
}