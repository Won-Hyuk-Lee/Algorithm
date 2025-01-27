import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

            int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] b = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            Arrays.sort(b);

            long result = 0;
            for (int number : a) {
                int closest = findClosest(b, number);
                result += closest;
            }

            bw.write(result + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    private static int findClosest(int[] sortedArray, int target) {
        int start = 0, end = sortedArray.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (sortedArray[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        if (start == 0) return sortedArray[start];
        if (start == sortedArray.length) return sortedArray[start - 1];

        int lower = sortedArray[start - 1];
        int upper = sortedArray[start];
        return Math.abs(target - lower) <= Math.abs(target - upper) ? lower : upper;
    }
}
