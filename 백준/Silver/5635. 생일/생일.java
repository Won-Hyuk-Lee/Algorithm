import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[][] arr = new String[n][4];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = st.nextToken(); // 이름
            arr[i][1] = st.nextToken(); // 일
            arr[i][2] = st.nextToken(); // 월
            arr[i][3] = st.nextToken(); // 년
        }

        Arrays.sort(arr, (a, b) -> {
            int yearDiff = Integer.parseInt(b[3]) - Integer.parseInt(a[3]);
            if (yearDiff != 0) return yearDiff;
            int monthDiff = Integer.parseInt(b[2]) - Integer.parseInt(a[2]);
            if (monthDiff != 0) return monthDiff;
            return Integer.parseInt(b[1]) - Integer.parseInt(a[1]);
        });

        System.out.println(arr[0][0]);
        System.out.println(arr[n - 1][0]);
    }
}
