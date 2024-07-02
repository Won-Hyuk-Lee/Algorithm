import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        //n이 1인 경우 1 출력
        if (n == 1) {
            System.out.print(1);
            return;
        }
        
        int count = 1; //몇겹인지
        int range = 1; //현재범위 최댓값
        
        //n이 현재 범위를 초과할 때까지 반복
        while (n > range) {
            range += 6 * count; // 다음 범위의 최댓값 계산
            count++; // 한겹++
        }
        
        System.out.print(count);
    }
}