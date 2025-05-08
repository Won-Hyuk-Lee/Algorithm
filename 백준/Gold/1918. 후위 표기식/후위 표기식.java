import java.io.*;
import java.util.*;

public class Main {
    static int prec(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }

    public static void main(String[] args) throws IOException {
        char[] expr = new BufferedReader(new InputStreamReader(System.in)).readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (char c : expr) {
            if (Character.isLetter(c)) sb.append(c);
            else if (c == '(') stack.push(c);
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    sb.append(stack.pop());
                stack.pop();
            } else {
                while (!stack.isEmpty() && prec(stack.peek()) >= prec(c))
                    sb.append(stack.pop());
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) sb.append(stack.pop());
        System.out.println(sb);
    }
}
