import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        for (int i = 1; i <= k; i++) {
            int n = sc.nextInt();
            int[] nums = new int[n];

            for (int j = 0; j < n; j++) {
                nums[j] = sc.nextInt();
            }

            Arrays.sort(nums);
            int max = nums[n - 1];
            int min = nums[0];
            int gap = 0;

            for (int j = 1; j < n; j++) {
                gap = Math.max(gap, nums[j] - nums[j - 1]);
            }

            System.out.printf("Class %d\nMax %d, Min %d, Largest gap %d\n", i, max, min, gap);
        }
    }
}