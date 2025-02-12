import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int p = Integer.parseInt(input[0]);
        int q = Integer.parseInt(input[1]);
        System.out.print((q - p) + " " + q);
    }
}
