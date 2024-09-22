import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int startH = sc.nextInt();
        int startM = sc.nextInt();

        int endH = sc.nextInt();
        int endM = sc.nextInt();

        int N = sc.nextInt();
        String target = Integer.toString(N);

        int count = 0;

        while (startH < endH || (startH == endH && startM <= endM)) {
            String time = String.format("%02d%02d", startH, startM);
            
            if (time.contains(target)) {
                count++;
            }

            startM++;
            if (startM == 60) {
                startM = 0;
                startH++;
            }
        }
        System.out.println(count);
    }
}
