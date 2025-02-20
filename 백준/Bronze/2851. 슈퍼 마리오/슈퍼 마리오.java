import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int sum = 0, answer = 0;
        for (int i = 0; i < 10; i++) {
            sum += Integer.parseInt(br.readLine());
            if (Math.abs(100 - sum) <= Math.abs(100 - answer)) {
                answer = sum;
            }
        }
        
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}