import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        
        // 세 각의 합이 180도가 아닌 경우
        if (a + b + c != 180) {
            System.out.print("Error");
        } else {
            // 세 각이 모두 60도
            if (a == 60 && b == 60 && c == 60) {
                System.out.print("Equilateral");
            // 두 각이 같은 경우
            } else if (a == b || b == c || c == a) {
                System.out.print("Isosceles");
            // 나머지 경우
            } else {
                System.out.print("Scalene");
            }
        }
    }
}
