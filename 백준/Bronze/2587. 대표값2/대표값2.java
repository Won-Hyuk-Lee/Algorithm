import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] num = new int[5]; // 숫자는 5개 주어지니까 정적인 배열 사용
        for (int i = 0; i < 5; i++)
        {
            num[i] = sc.nextInt();
        }
        Arrays.sort(num); // 오름차순으로 정렬
        System.out.println(Arrays.stream(num).sum()/5); //평균
        System.out.print(num[2]); //중앙값은 중앙에 위치한값
    }
}
