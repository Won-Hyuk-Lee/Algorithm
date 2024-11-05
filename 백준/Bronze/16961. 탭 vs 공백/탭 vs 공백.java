import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] guests = new int[367];
        int[] tabGuests = new int[367];
        int[] spaceGuests = new int[367];
        int longestStay = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char type = st.nextToken().charAt(0);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            longestStay = Math.max(longestStay, end - start + 1);

            for (int day = start; day <= end; day++) {
                guests[day]++;
                if (type == 'T') {
                    tabGuests[day]++;
                } else {
                    spaceGuests[day]++;
                }
            }
        }

        int totalDaysWithGuests = 0;
        int maxGuestsOnSingleDay = 0;
        int noFightDays = 0;
        int maxGuestsOnNoFightDay = 0;

        for (int day = 1; day <= 366; day++) {
            int totalGuests = guests[day];
            int tabs = tabGuests[day];
            int spaces = spaceGuests[day];
            
            if (totalGuests > 0) {
                totalDaysWithGuests++;
                maxGuestsOnSingleDay = Math.max(maxGuestsOnSingleDay, totalGuests);
            }
            
            if (tabs == spaces && tabs > 0) {
                noFightDays++;
                maxGuestsOnNoFightDay = Math.max(maxGuestsOnNoFightDay, totalGuests);
            }
        }

        System.out.println(totalDaysWithGuests);
        System.out.println(maxGuestsOnSingleDay);
        System.out.println(noFightDays);
        System.out.println(maxGuestsOnNoFightDay);
        System.out.println(longestStay);
    }
}