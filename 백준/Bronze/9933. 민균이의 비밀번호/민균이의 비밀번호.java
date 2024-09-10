import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            set.add(s);

            StringBuilder sb = new StringBuilder(s);
            String reverse = sb.reverse().toString(); 

            if (set.contains(reverse))
            { 
                System.out.println(reverse.length() + " " + reverse.charAt(reverse.length() / 2));
                break; 
            }
        }
    }
}