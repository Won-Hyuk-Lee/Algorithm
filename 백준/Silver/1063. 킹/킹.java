import java.util.Scanner;

public class Main {
    static int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
    static int[] dy = {0, 0, -1, 1, 1, 1, -1, -1};
    static String[] direction = {"R", "L", "B", "T", "RT", "LT", "RB", "LB"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String king = sc.next();
        String stone = sc.next();
        int N = sc.nextInt();

        int kingX = king.charAt(0) - 'A';
        int kingY = king.charAt(1) - '1';
        int stoneX = stone.charAt(0) - 'A';
        int stoneY = stone.charAt(1) - '1';

        for (int i = 0; i < N; i++) {
            String move = sc.next();
            for (int j = 0; j < 8; j++) {
                if (move.equals(direction[j])) {
                    int nextKingX = kingX + dx[j];
                    int nextKingY = kingY + dy[j];

                    if (isInBounds(nextKingX, nextKingY)) {
                        if (nextKingX == stoneX && nextKingY == stoneY) {
                            int nextStoneX = stoneX + dx[j];
                            int nextStoneY = stoneY + dy[j];

                            if (isInBounds(nextStoneX, nextStoneY)) {
                                stoneX = nextStoneX;
                                stoneY = nextStoneY;
                                kingX = nextKingX;
                                kingY = nextKingY;
                            }
                        } else {
                            kingX = nextKingX;
                            kingY = nextKingY;
                        }
                    }
                    break;
                }
            }
        }

        System.out.println((char) (kingX + 'A') + "" + (kingY + 1));
        System.out.println((char) (stoneX + 'A') + "" + (stoneY + 1));
    }
    
    public static boolean isInBounds(int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }
}
