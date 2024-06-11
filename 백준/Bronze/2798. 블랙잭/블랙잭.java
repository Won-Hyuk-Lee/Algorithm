import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int result = search(arr, n, m);
        System.out.println(result);
    }

    // 최대 합을 찾는 함수
    static int search(int[] arr, int n, int m) {
        int result = 0;

        // 첫 번째 카드를 n - 2 까지 순회
        for (int i = 0; i < n - 2; i++) {
            
            // 두 번째 카드를 첫 번째 카드 다음부터 n - 1 까지 순회
            for (int j = i + 1; j < n - 1; j++) {
                
                // 세 번째 카드를 두 번째 카드 다음부터 n 까지 순회
                for (int k = j + 1; k < n; k++) {
                    
                    // 세 카드의 합 계산
                    int temp = arr[i] + arr[j] + arr[k];
                    
                    // m과 세 카드의 합이 같다면 그 값을 반환 및 종료
                    if (m == temp) {    
                        return temp;
                    }
                    
                    // 세 카드의 합이 이전 최대 합보다 크고 m보다 작을 경우 결과를 갱신
                    if (result < temp && temp < m) {
                        result = temp;
                    }
                }
            }
        }
        
        // 모든 순회 이후 결과 반환
        return result;
    }
}
