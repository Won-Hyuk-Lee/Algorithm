import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String word = sc.next();
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = word.charAt(0) + "" + word.charAt(word.length() - 1) + new String(chars);
            map.put(key, word);
        }
        int m = sc.nextInt();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String testWord = sc.next();
            char[] chars = testWord.toCharArray();
            Arrays.sort(chars);
            String key = testWord.charAt(0) + "" + testWord.charAt(testWord.length() - 1) + new String(chars);
            result.append(map.get(key)).append(' ');
        }
        System.out.println(result.toString().trim());
    }
}
