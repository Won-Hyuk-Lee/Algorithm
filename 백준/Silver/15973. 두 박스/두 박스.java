import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] a = new int[4];
        int[] b = new int[4];

        for (int i = 0; i < 4; i++) a[i] = sc.nextInt();
        for (int i = 0; i < 4; i++) b[i] = sc.nextInt();

        int ax1 = a[0], ay1 = a[1], ax2 = a[2], ay2 = a[3];
        int bx1 = b[0], by1 = b[1], bx2 = b[2], by2 = b[3];

        int left = Math.max(ax1, bx1);
        int right = Math.min(ax2, bx2);
        int bottom = Math.max(ay1, by1);
        int top = Math.min(ay2, by2);

        if (right < left || top < bottom) {
            System.out.println("NULL");
        } else if (left == right && bottom == top) {
            System.out.println("POINT");
        } else if (left == right || bottom == top) {
            System.out.println("LINE");
        } else {
            System.out.println("FACE");
        }
    }
}
