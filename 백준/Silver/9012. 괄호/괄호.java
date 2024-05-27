import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num ; i++)
        {
            Stack<Character> stack = new Stack<>();
            String s = br.readLine();
            boolean check = true;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '(')
                {
                    stack.push('('); // '('이면 스택에 push
                } else
                {
                    // ')'면 스택에서 pop
                    if (stack.isEmpty())
                    {
                        check = false;
                        break;
                    }
                    stack.pop();
                }
            }
            if (!stack.isEmpty()) check = false;
            if (check) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.print(sb);
    }
}