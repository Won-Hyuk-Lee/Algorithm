import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    static ArrayList<Long> solution(long num){
        ArrayList<Long> fivo = new ArrayList<>();
        ArrayList<Long> answer = new ArrayList<>();
        fivo.add(0L);
        fivo.add(1L);
        int index = 2;
        
        while (true) {
            long plusNum = fivo.get(index - 1) + fivo.get(index - 2);
            if(plusNum > num) break;
            fivo.add(plusNum);
            index++;
        }

        Collections.sort(fivo,Collections.reverseOrder());
		
        while(num != 0) {
            for (int i = 0; i < fivo.size(); i++) {
                if (fivo.get(i) <= num) {
                    num -= fivo.get(i);
                    answer.add(fivo.get(i));
                }
            }
        }

        Collections.sort(answer);
        answer.remove(0);
        return answer;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {

            long num = sc.nextInt();

            for (long x : solution(num)) {
                System.out.printf(x + " ");
            }
            System.out.println();

        }

    }
}