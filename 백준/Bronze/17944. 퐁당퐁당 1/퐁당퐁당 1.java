import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();  //사람
        int T = sc.nextInt();  //계산차례

        //사이클 주기
        int cycle = 4 * N - 2;

        //T번 차례에서 주기 위치 계산
        int tCycle = T % cycle;
        if (tCycle == 0) tCycle = cycle;

        //주기 내에서 팔 계산
        int arms;
        if (tCycle <= 2 * N) {
            arms = tCycle;
        } else {
            arms = 4 * N - tCycle;
        }

        System.out.println(arms);
    }
}
