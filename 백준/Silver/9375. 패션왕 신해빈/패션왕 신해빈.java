import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int testCaseCount = scanner.nextInt();

        while (testCaseCount-- > 0) {

            HashMap<String, Integer> clothingCountMap = new HashMap<>();

            int clothingItemCount = scanner.nextInt();

            for (int i = 0; i < clothingItemCount; i++) {
                scanner.next();
                String clothingType = scanner.next(); //옷 종류 입력

                //있으면 개수++ 없으면 1로
                clothingCountMap.put(clothingType, clothingCountMap.getOrDefault(clothingType, 0) + 1);
            }

            int outfitCount = 1;

            //안 입는 경우 더하고 곱
            for (int count : clothingCountMap.values()) {
                outfitCount *= (count + 1);
            }

            System.out.println(outfitCount - 1); //알몸인 상태 -1
        }

        scanner.close();
    }
}
