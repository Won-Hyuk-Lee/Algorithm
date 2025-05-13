import java.io.*;
import java.util.*;

public class Main {
    static int[] A, B;
    static int n, m;
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        m = Integer.parseInt(br.readLine());
        B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int idxA = 0, idxB = 0;
        while (idxA < n && idxB < m) {
            int max = 0;
            int nextA = -1, nextB = -1;
            for (int i = idxA; i < n; i++) {
                for (int j = idxB; j < m; j++) {
                    if (A[i] == B[j] && A[i] > max) {
                        max = A[i];
                        nextA = i;
                        nextB = j;
                    }
                }
            }
            if (max == 0) break;
            result.add(max);
            idxA = nextA + 1;
            idxB = nextB + 1;
        }

        if (result.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(result.size());
            for (int num : result) System.out.print(num + " ");
        }
    }
}
