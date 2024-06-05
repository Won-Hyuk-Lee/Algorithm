import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 세 개의 정수 배열에
        int arr[] = {sc.nextInt(), sc.nextInt(), sc.nextInt()};
        sc.close();

        /* 
        배열의 길이는 3으로 고정되어 있으니 단순 선택 정렬을 사용하여 최적화
        첫 번째와 두 번째 원소를 비교 후, 두 번째와 세 번째 원소를 비교
        */
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }

        // 정렬된 배열의 두 번째(중간값)를 출력
        System.out.println(arr[1]);
    }
}
