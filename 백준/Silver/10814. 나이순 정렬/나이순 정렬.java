import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(); // 입력받을 데이터의 수
        String[][] arr = new String[n][2]; // 나이와 이름을 저장할 배열
        
        // 입력받기
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.next();  // 나이
            arr[i][1] = sc.next();  // 이름
        }

        // 나이순으로 정렬
        Arrays.sort(arr, new Comparator<String[]>() {
            @Override
            public int compare(String[] s1, String[] s2) {
                return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
            }
        });

        StringBuilder sb = new StringBuilder();
        
        // 결과를 StringBuilder에 추가
        for (int i = 0; i < n; i++) {
            sb.append(arr[i][0]).append(' ').append(arr[i][1]).append('\n');
        }
        
        // 결과 출력
        System.out.print(sb);
    }
}
