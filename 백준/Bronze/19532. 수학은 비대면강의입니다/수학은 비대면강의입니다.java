import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        //공백을 기준으로 분리하여 저장
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        reader.close();

        //첫번째 방정식의 계수와 상수항
        int a = Integer.parseInt(tokenizer.nextToken());
        int b = Integer.parseInt(tokenizer.nextToken());
        int c = Integer.parseInt(tokenizer.nextToken());

        //두번째 방정식의 계수와 상수항
        int d = Integer.parseInt(tokenizer.nextToken());
        int e = Integer.parseInt(tokenizer.nextToken());
        int f = Integer.parseInt(tokenizer.nextToken());

        //행렬식 D 계산
        int determinant = a * e - b * d;

        //x와 y 계산 (크래머의 법칙 사용)
        int x = (c * e - b * f) / determinant;
        int y = (a * f - c * d) / determinant;

        writer.write(x + " " + y + "\n");

        writer.flush();
        writer.close();
    }
}
