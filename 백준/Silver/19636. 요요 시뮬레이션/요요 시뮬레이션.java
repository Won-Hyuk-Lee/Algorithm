import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int initialWeight = Integer.parseInt(st.nextToken());
        int baseMetabolism = Integer.parseInt(st.nextToken());
        int threshold = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int days = Integer.parseInt(st.nextToken());
        int dailyIntake = Integer.parseInt(st.nextToken());
        int dailyActivity = Integer.parseInt(st.nextToken());

        int weight1 = initialWeight, weight2 = initialWeight;
        int baseMetabolism2 = baseMetabolism;

        //일일 변화 계산
        for (int i = 0; i < days; i++) {
            //기초대사량 변화반영X
            weight1 += dailyIntake - (baseMetabolism + dailyActivity);

            //기초대사량 변화반영
            weight2 += dailyIntake - (baseMetabolism2 + dailyActivity);
            if (Math.abs(dailyIntake - (baseMetabolism2 + dailyActivity)) > threshold) {
                baseMetabolism2 += Math.floor((dailyIntake - (baseMetabolism2 + dailyActivity)) / 2.0);
            }
        }

        //변화 반영 X
        if (weight1 <= 0) {
            System.out.println("Danger Diet");
        } else {
            System.out.println(weight1 + " " + baseMetabolism);
        }

        //변화 반영 O
        if (weight2 <= 0 || baseMetabolism2 <= 0) {
            System.out.println("Danger Diet");
        } else {
            System.out.print(weight2 + " " + baseMetabolism2 + " ");
            if (baseMetabolism - baseMetabolism2 > 0) {
                System.out.println("YOYO");
            } else {
                System.out.println("NO");
            }
        }
    }
}
