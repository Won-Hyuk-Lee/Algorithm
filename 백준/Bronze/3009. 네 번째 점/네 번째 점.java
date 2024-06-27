import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] firstCoordinate = { sc.nextInt(), sc.nextInt() }; // 첫번째 좌표
        int[] secondCoordinate = { sc.nextInt(), sc.nextInt() }; // 두번째 좌표
        int[] thirdCoordinate = { sc.nextInt(), sc.nextInt() }; // 세번째 좌표

        sc.close();

        int x = findUniqueCoordinate(firstCoordinate[0], secondCoordinate[0], thirdCoordinate[0]);
        int y = findUniqueCoordinate(firstCoordinate[1], secondCoordinate[1], thirdCoordinate[1]);
        
        System.out.println(x + " " + y);
    }

    private static int findUniqueCoordinate(int a, int b, int c) {
        // 각 좌표 맵
        Map<Integer, Integer> coordinateCount = new HashMap<>();
        
        // 좌표값의 빈도
        coordinateCount.put(a, coordinateCount.getOrDefault(a, 0) + 1);
        coordinateCount.put(b, coordinateCount.getOrDefault(b, 0) + 1);
        coordinateCount.put(c, coordinateCount.getOrDefault(c, 0) + 1);
        
        // 빈도가 1인 좌표값
        for (Map.Entry<Integer, Integer> entry : coordinateCount.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        
        // 없을경우
        return -1;
    }
}
