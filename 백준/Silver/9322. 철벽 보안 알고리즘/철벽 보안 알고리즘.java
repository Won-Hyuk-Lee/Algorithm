import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();

        for (int t = 0; t < test; t++) {
            int n = scanner.nextInt();
            String[] s1 = new String[n];
            String[] s2 = new String[n];
            String[] pass = new String[n];

            for (int i = 0; i < n; i++) s1[i] = scanner.next();
            for (int i = 0; i < n; i++) s2[i] = scanner.next();
            for (int i = 0; i < n; i++) pass[i] = scanner.next();

            Map<String, String> wordToPass = new HashMap<>();
            for (int i = 0; i < n; i++) {
                wordToPass.put(s2[i], pass[i]);
            }

            StringBuilder res = new StringBuilder();
            for (int i = 0; i < n; i++) {
                res.append(wordToPass.get(s1[i])).append(" ");
            }

            System.out.println(res.toString().trim());
        }
    }
}
