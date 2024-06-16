import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        // 초기 값 설정
        if (n == 1) {
            System.out.println(1);
            return;
        } else if (n == 2) {
            System.out.println(2);
            return;
        }
        
        int prev1 = 1; // n-2 번째 값
        int prev2 = 2; // n-1 번째 값
        int current = 0; // 현재 n 번째 값
        
        // dp로 n 번째 값 계산
        for (int i = 3; i <= n; i++) {
            current = (prev1 + prev2) % 10007;
            prev1 = prev2;
            prev2 = current;
        }
        
        System.out.println(current);
    }
}
