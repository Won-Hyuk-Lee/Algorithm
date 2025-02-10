import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                sb.append("0\n");
                continue;
            }
            
            boolean isNegative = n < 0;
            if (isNegative) n = -n;
            
            StringBuilder temp = new StringBuilder();
            while (n > 0) {
                int r = n % 3;
                n /= 3;
                
                if (r == 2) {
                    r = -1;
                    n++;
                }
                
                if (r == -1) temp.append('-');
                else temp.append(r);
            }
            
            String result = temp.reverse().toString();
            if (isNegative) {
                temp = new StringBuilder();
                for (char c : result.toCharArray()) {
                    if (c == '1') temp.append('-');
                    else if (c == '-') temp.append('1');
                    else temp.append('0');
                }
                result = temp.toString();
            }
            
            sb.append(result).append('\n');
        }
        
        System.out.print(sb);
        br.close();
    }
}