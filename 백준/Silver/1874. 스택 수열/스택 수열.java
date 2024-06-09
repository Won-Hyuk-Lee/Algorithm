import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(); // 출력할 결과물을 저장할 StringBuilder
        
        Stack<Integer> stack = new Stack<>(); // 스택 생성
        
        int n = sc.nextInt(); // 입력받을 수의 개수
        
        int start = 0; // 현재 스택에 넣은 최대값을 저장하는 변수
        

        while (n-- > 0) {
            int value = sc.nextInt(); // 입력값
            
            // 입력값이 start보다 큰 경우
            if (value > start) {
                // start + 1부터 입력받은 value까지 push
                for (int i = start + 1; i <= value; i++) {
                    stack.push(i); // 스택에 값 추가
                    sb.append('+').append('\n'); // '+'를 결과에 추가
                }
                start = value; // start 값을 현재 입력값으로 업데이트
            }
            
            // 스택의 최상단 값이 입력값과 다른 경우
            else if (stack.peek() != value) {
                System.out.println("NO");
                return; // 프로그램 종료
            }
            
            stack.pop(); // 스택에서 값 제거
            sb.append('-').append('\n'); // '-'를 결과에 추가
        }
        
        System.out.println(sb); // 결과 출력
    }
}
