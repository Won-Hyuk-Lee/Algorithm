import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        String ML = input[0], MR = input[1], TL = input[2], TR = input[3];

        if (canAlwaysWin(ML, MR, TL, TR)) {
            System.out.println("MS");
        } else if (canAlwaysWin(TL, TR, ML, MR)) {
            System.out.println("TK");
        } else {
            System.out.println("?");
        }
    }

    private static boolean canAlwaysWin(String A1, String A2, String B1, String B2) {
        return (wins(A1, B1) && wins(A1, B2)) || (wins(A2, B1) && wins(A2, B2));
    }

    private static boolean wins(String a, String b) {
        return (a.equals("R") && b.equals("S")) || 
               (a.equals("S") && b.equals("P")) || 
               (a.equals("P") && b.equals("R"));
    }
}
