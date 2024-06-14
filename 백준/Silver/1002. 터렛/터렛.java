import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt(); // 테스트 케이스

        while (T-- > 0) {
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int r1 = in.nextInt();

            int x2 = in.nextInt();
            int y2 = in.nextInt();
            int r2 = in.nextInt();

            System.out.println(tangentPoint(x1, y1, r1, x2, y2, r2));
        }

        in.close();
    }

    // 접점 개수를 구하는 함수
    public static int tangentPoint(int x1, int y1, int r1, int x2, int y2, int r2) {
        // 중점간 거리 distance의 제곱
        int distanceSquared = (int) (Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        // 중점이 같으면서 반지름도 같을 경우
        if (x1 == x2 && y1 == y2 && r1 == r2) {
            return -1; // 무한대의 접점
        }
        
        // 두 원의 반지름 합보다 중점간 거리가 더 길 때
        if (distanceSquared > Math.pow(r1 + r2, 2)) {
            return 0; // 접점이 없음
        }
        
        // 원 안에 원이 있으나 내접하지 않을 때
        if (distanceSquared < Math.pow(r2 - r1, 2)) {
            return 0; // 접점이 없음
        }
        
        // 내접할 때
        if (distanceSquared == Math.pow(r2 - r1, 2)) {
            return 1; // 한 개의 접점
        }

        // 외접할 때
        if (distanceSquared == Math.pow(r1 + r2, 2)) {
            return 1; // 한 개의 접점
        }

        // 그 외
        return 2;
    }
}
