import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<int[]> allSquare = new ArrayList<>(11250); //예상 크기

        for (int h = 1; h <= 150; h++) {
            for (int w = h + 1; w <= 150; w++) {
                allSquare.add(new int[]{h, w});
            }
        }

        allSquare.sort(Comparator.comparingInt(a -> a[0] * a[0] + a[1] * a[1]));

        String input;
        while (!(input = br.readLine()).equals("0 0")) {
            String[] parts = input.split(" ");
            int h = Integer.parseInt(parts[0]);
            int w = Integer.parseInt(parts[1]);

            int index = 0;
            while (index < allSquare.size() && !(allSquare.get(index)[0] == h && allSquare.get(index)[1] == w)) {
                index++;
            }

            int[] nextSquare = allSquare.get(index + 1);
            System.out.println(nextSquare[0] + " " + nextSquare[1]);
        }
    }
}
