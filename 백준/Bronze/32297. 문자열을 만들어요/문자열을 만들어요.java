import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());

        //문자열을 입력받아 특정패턴검사
        String name = reader.readLine().trim();

        if (name.contains("gori")) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
