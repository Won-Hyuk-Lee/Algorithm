import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] modCount = new long[M];
        st = new StringTokenizer(br.readLine());
        long sum = 0;
        long result = 0;
        modCount[0] = 1;

        for (int i = 0; i < N; i++) {
            sum = (sum + Integer.parseInt(st.nextToken())) % M;
            result += modCount[(int) sum]++;
        }

        System.out.println(result);
    }
}
