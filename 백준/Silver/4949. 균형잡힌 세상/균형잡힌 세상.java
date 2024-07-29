import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            String str = br.readLine();
            
            //.프로그램 종료
            if (str.equals(".")) break;
            
            //문자열 체크 메서드 호출
            if (isBalanced(str)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    //문자열 균형체크 메서드
    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            
            //여는 괄호는 스택에 넣고
            if (ch == '(' || ch == '[') {
                stack.push(ch);
            }
            //닫는 괄호중 소괄호 일때
            else if (ch == ')') {
                //스택이 비어 있거나 가장 최근에 넣은게 (가 아니면 false 반환
                if (stack.isEmpty() || stack.peek() != '(') {
                    return false;
                } else {
                    stack.pop(); //( 제거
                }
            }
            //닫는 대괄호 일때
            else if (ch == ']') {
                //스택이 비어 있거나 가장 최근에 넣은게 [가 아니면 false 반환
                if (stack.isEmpty() || stack.peek() != '[') {
                    return false;
                } else {
                    stack.pop(); //[ 제거
                }
            }
        }
        
        //스택이 비어있으면 모두 짝이 있는것임(스택도 짝이 있네...)
        return stack.isEmpty();
    }
}
