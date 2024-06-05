import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader를 사용하여 입력 속도 높임
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringBuilder를 사용하여 출력 문자열을 효율적으로
        StringBuilder sb = new StringBuilder();

        // 입력 데이터의 크기 n
        int n = Integer.parseInt(br.readLine());

        // ArrayList를 예상 크기로 초기화
        ArrayList<Integer> list = new ArrayList<>(n);

        // n개의 정수 리스트 추가
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        // 리스트 정렬
        Collections.sort(list);

        // 정렬된 리스트를 StringBuilder에 추가
        for (int value : list) {
            sb.append(value).append('\n');
        }
        
        System.out.println(sb);
    }
}
