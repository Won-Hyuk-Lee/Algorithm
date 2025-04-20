import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            double t = sc.nextDouble();
            int x = sc.nextInt();
            
            double radians = Math.toRadians(x);
            double left = t * 100 - (16.0 / Math.sin(radians));
            double right = t * 100 + (16.0 / Math.sin(radians));
            double step = 85.0 / Math.tan(radians);
            
            double dist = 0;
            boolean hit = false;
            
            while (dist < right) {
                if (left < dist && dist < right) {
                    System.out.println("yes");
                    hit = true;
                    break;
                }
                dist += step;
            }
            
            if (!hit) {
                System.out.println("no");
            }
        }
        sc.close();
    }
}