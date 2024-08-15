import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());

        String[] daysOfWeek = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; 

        //월별 누적되는 일수를 미리 계산함
        int[] cumulativeDays = new int[13];
        for (int i = 1; i <= 12; i++) {
            cumulativeDays[i] = cumulativeDays[i - 1] + daysInMonth[i];
        }

        //1월 1일은 월요일이므로 누적된 일수 + 주어진 날짜에서 -1
        int totalDays = cumulativeDays[month - 1] + day - 1;
        System.out.print(daysOfWeek[totalDays % 7]);
    }
}
