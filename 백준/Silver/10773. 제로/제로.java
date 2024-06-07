import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        // k번 반복
        for(int i = 0; i < k; i++) {
            // 입력받은 정수 temp
            int temp = Integer.parseInt(br.readLine());

            // temp가 0이면 스택에서 숫자 하나를 제거
            if(temp == 0) {
                stack.pop();
            } else {
                // temp가 0이 아니면 스택에 숫자를 추가
                stack.push(temp);
            }
        }

        // 스택에 남아 있는 숫자들의 합을 계산
        int sum = 0;
        for(int num : stack) {
            sum += num;
        }
        System.out.println(sum);
    }
}
