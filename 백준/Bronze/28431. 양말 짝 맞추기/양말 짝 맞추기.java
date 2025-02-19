import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int i = 0; i < 5; i++) {
            int num = sc.nextInt();
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for (int key : countMap.keySet()) {
            if (countMap.get(key) % 2 == 1) {
                System.out.println(key);
                break;
            }
        }
        
        sc.close();
    }
}
