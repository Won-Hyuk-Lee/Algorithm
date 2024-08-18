import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while ((input = reader.readLine()) != null) {
            StringTokenizer tokenizer = new StringTokenizer(input);
            int first = Integer.parseInt(tokenizer.nextToken());
            int second = Integer.parseInt(tokenizer.nextToken());
            int third = Integer.parseInt(tokenizer.nextToken());

            //1-2, 2-3사이의 거리 계산
            int distance12 = second - first;
            int distance23 = third - second;

            //두거리 큰 값을 선택해서 1을 빼면 최대횟수
            int maxMove = Math.max(distance12, distance23) - 1;

            System.out.println(maxMove);
        }
    }
}
