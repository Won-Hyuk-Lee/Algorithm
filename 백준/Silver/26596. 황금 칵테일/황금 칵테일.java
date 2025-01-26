import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Map<String, Integer> mp = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String s = sc.next();
            int x = sc.nextInt();
            mp.put(s, mp.getOrDefault(s, 0) + x);
        }

        int[] values = mp.values().stream().mapToInt(Integer::intValue).toArray();
        int size = values.length;

        for (int i = 0; i < size; i++) {
            int xx = values[i] * 1618 / 1000;
            for (int j = 0; j < size; j++) {
                if (i != j && xx == values[j]) {
                    System.out.print("Delicious!");
                    return;
                }
            }
        }

        System.out.print("Not Delicious...");
    }
}
