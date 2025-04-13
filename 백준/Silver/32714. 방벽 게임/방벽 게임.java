import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        if (N <= 3) {
            bw.write(String.valueOf("0013".charAt(N)));
        } else {
            bw.write(String.valueOf(N * 3 - 4));
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}