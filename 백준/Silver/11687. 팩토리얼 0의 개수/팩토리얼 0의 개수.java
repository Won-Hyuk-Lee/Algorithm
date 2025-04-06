import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        System.out.println(binarySearch(M, 1, 1_000_000_000));
    }

    public static int binarySearch(int key, int left, int right) {
        int result = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int zeroCount = findZero(mid);

            if (zeroCount < key) {
                left = mid + 1;
            } else {
                if (zeroCount == key) result = mid;
                right = mid - 1;
            }
        }
        return result;
    }

    public static int findZero(int n) {
        int count = 0;
        for (int i = 5; i <= n; i *= 5) {
            count += n / i;
        }
        return count;
    }
}
