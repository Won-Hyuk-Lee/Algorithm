import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder s = new StringBuilder("2".repeat(100));
        StringBuilder ans = new StringBuilder();

        int before = Integer.parseInt(reader.readLine());

        for (int i = 0; i < 100; i++) {
            s.setCharAt(i, '0');
            System.out.println("? " + s);
            System.out.flush();
            int now = Integer.parseInt(reader.readLine());

            if (now < before) {
                ans.append('5');
            } else if (now == before) {
                ans.append('0');
            } else {
                ans.append('2');
            }
            s.setCharAt(i, '2');
        }

        System.out.println("! " + ans);
        System.out.flush();
    }
}
