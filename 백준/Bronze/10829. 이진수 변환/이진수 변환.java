import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long inputNum = Long.parseLong(br.readLine());
        ArrayList<Long> numArrList = new ArrayList<>();

        for (int i = 0; 0 < inputNum; i++) {
            long num = inputNum % 2;
            inputNum /= 2;
            numArrList.add(num);
        }

        Collections.reverse(numArrList);

        for (long num:numArrList) {
            System.out.printf("%d", num);
        }
    }
}