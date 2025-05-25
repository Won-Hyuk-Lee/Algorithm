import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.nextLine();
        String bracket = in.nextLine();
        Stack<Character> stk = new Stack<>();
        int result = 0;

        for (char c : bracket.toCharArray()) {
            if (!stk.isEmpty() && stk.peek() != c) {
                stk.pop();
            } else {
                stk.push(c);
            }
            result = Math.max(result, stk.size());
        }

        System.out.println(stk.isEmpty() ? result : -1);
    }
}
