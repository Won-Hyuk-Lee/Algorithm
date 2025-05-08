import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        char[] arr = new BufferedReader(new InputStreamReader(System.in)).readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        int p = 0;

        for (char c : arr) {
            stack.push(c);
            if (stack.size() >= 4 &&
                stack.get(stack.size() - 1) == 'P' &&
                stack.get(stack.size() - 2) == 'A' &&
                stack.get(stack.size() - 3) == 'P' &&
                stack.get(stack.size() - 4) == 'P') {
                for (int i = 0; i < 4; i++) stack.pop();
                stack.push('P');
            }
        }

        System.out.println(stack.size() == 1 && stack.peek() == 'P' ? "PPAP" : "NP");
    }
}
