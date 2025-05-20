import java.io.*;
import java.util.*;

public class Main {
    static int lowerBound(List<Integer> list, int key) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (list.get(mid) < key)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    static int lowerBoundReverse(List<Integer> list, int key) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (key < list.get(mid))
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int[] diff = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            diff[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int pos = lowerBound(nums, diff[i]);
            left[i] = pos + 1;
            if (pos == nums.size()) nums.add(diff[i]);
            else nums.set(pos, diff[i]);
        }

        nums.clear();
        for (int i = n - 1; i >= 0; i--) {
            int pos = lowerBoundReverse(nums, diff[i]);
            right[i] = pos + 1;
            if (pos == nums.size()) nums.add(diff[i]);
            else nums.set(pos, diff[i]);
        }

        for (int i = 0; i < q; i++) {
            int d = Integer.parseInt(br.readLine());
            bw.write((left[d - 1] + right[d - 1] - 1) + "\n");
        }

        bw.flush();
    }
}
