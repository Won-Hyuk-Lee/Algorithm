import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double max = 0, curr = 0;

        for (int i = 0; i < n; i++) {
            double val = Double.parseDouble(br.readLine());
            curr = (i == 0) ? val : Math.max(val, curr * val);
            max = Math.max(max, curr);
        }

        System.out.printf("%.3f", max);
    }
}
