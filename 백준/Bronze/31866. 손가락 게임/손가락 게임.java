import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        String b = st.nextToken();

        Set<String> valid = new HashSet<>(Arrays.asList("0", "2", "5"));

        if (valid.contains(a) && !valid.contains(b)) {
            System.out.println(">");
        } else if (!valid.contains(a) && valid.contains(b)) {
            System.out.println("<");
        } else if ((a.equals("0") && b.equals("2")) || 
                   (a.equals("2") && b.equals("5")) || 
                   (a.equals("5") && b.equals("0"))) {
            System.out.println(">");
        } else if ((a.equals("2") && b.equals("0")) || 
                   (a.equals("5") && b.equals("2")) || 
                   (a.equals("0") && b.equals("5"))) {
            System.out.println("<");
        } else {
            System.out.println("=");
        }

        br.close();
    }
}
