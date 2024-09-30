import java.util.Scanner;

public class Main {

    static int diff(int startH, int startM, int endH, int endM) {
        return (endH - startH) * 60 + (endM - startM);
    }

    static void PLUS(int H, int M, int plus) {
        M += plus;
        H += M / 60;
        M %= 60;
        H %= 24;

        System.out.printf("%02d:%02d\n", H, M);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] start = sc.next().split(":");
        String[] end = sc.next().split(":");
        
        int startH = Integer.parseInt(start[0]);
        int startM = Integer.parseInt(start[1]);
        int endH = Integer.parseInt(end[0]);
        int endM = Integer.parseInt(end[1]);
        
        int total = diff(startH, startM, endH, endM);
        
        //N 배송할 택배 수
        //T 택배 건당 걸리는 시간
        int N = sc.nextInt();
        int T = sc.nextInt();
        
        //하루에 처리하는 택배 수
        int oneday = (total % T == 0) ? total / T - 1 : total / T;

        int bsDay = N / oneday;
        
        int bsTime = ((N % oneday) + 1) * T + startH * 60 + startM;

        int bsh = (bsTime / 60) % 24;
        int bsm = bsTime % 60;

        System.out.println(bsDay);
        System.out.printf("%02d:%02d\n", bsh, bsm);
    }
}
