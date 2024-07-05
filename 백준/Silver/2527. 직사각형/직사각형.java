import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 4; i++) {
            //직사각형1 좌표
            int rect1_x1 = sc.nextInt();
            int rect1_y1 = sc.nextInt();
            int rect1_x2 = sc.nextInt();
            int rect1_y2 = sc.nextInt();

            //직사각형2 좌표
            int rect2_x1 = sc.nextInt();
            int rect2_y1 = sc.nextInt();
            int rect2_x2 = sc.nextInt();
            int rect2_y2 = sc.nextInt();

            //만나지않음
            if (rect1_x2 < rect2_x1 || rect1_y2 < rect2_y1 || rect2_x2 < rect1_x1 || rect2_y2 < rect1_y1) {
                System.out.println("d");
            }
            //점에서 만날때
            else if ((rect1_x1 == rect2_x2 && rect1_y1 == rect2_y2) || 
                     (rect1_x1 == rect2_x2 && rect1_y2 == rect2_y1) || 
                     (rect1_x2 == rect2_x1 && rect1_y2 == rect2_y1) || 
                     (rect1_x2 == rect2_x1 && rect1_y1 == rect2_y2)) {
                System.out.println("c");
            }
            //선에서 만날때
            else if (rect1_x2 == rect2_x1 || rect1_y2 == rect2_y1 || 
                     rect2_x2 == rect1_x1 || rect2_y2 == rect1_y1) {
                System.out.println("b");
            }
            //겹칠때
            else {
                System.out.println("a");
            }
        }
        sc.close();
    }
}
