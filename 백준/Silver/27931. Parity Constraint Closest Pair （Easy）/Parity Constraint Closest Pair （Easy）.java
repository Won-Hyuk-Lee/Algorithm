import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        var st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        List<Integer> even = new ArrayList<>(), odd = new ArrayList<>();
        for (int x : arr) {
            if ((x & 1) == 0) even.add(x);
            else odd.add(x);
        }
        int minEven = Integer.MAX_VALUE, minOdd = Integer.MAX_VALUE;
        for (int i = 1; i < even.size(); i++)
            minEven = Math.min(minEven, even.get(i) - even.get(i - 1));
        for (int i = 1; i < odd.size(); i++)
            minEven = Math.min(minEven, odd.get(i) - odd.get(i - 1));
        int i = 0, j = 0;
        while (i < even.size() && j < odd.size()) {
            int diff = Math.abs(even.get(i) - odd.get(j));
            minOdd = Math.min(minOdd, diff);
            if (even.get(i) < odd.get(j)) i++;
            else j++;
        }
        System.out.print((minEven == Integer.MAX_VALUE ? -1 : minEven) + " ");
        System.out.println((minOdd == Integer.MAX_VALUE ? -1 : minOdd));
    }
}
