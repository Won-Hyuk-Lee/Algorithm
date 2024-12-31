import java.util.*;
import java.io.*;
public class Main{
    
    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        char input[] = br.readLine().toCharArray();
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0;i<input.length;i++) {
            if(input[i] >= '0') {
                stack.push((int)(input[i] - '0'));
            }else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                switch(input[i]) {
                    case '+':
                        stack.push(num1 + num2);
                        break;
                    case '-':
                        stack.push(num2 - num1);
                        break;
                    case '*':
                        stack.push(num1 * num2);
                        break;
                    case '/':
                        stack.push(num2 / num1);
                        break;
                }
            }
        }
        sb.append(stack.pop());
        sb.append("\n"); 
        
        bw.write(sb.toString());
        
        bw.flush();
        br.close();
        bw.close();
        
    }

    
}