import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int left = Integer.parseInt(reader.readLine());
        int right = Integer.parseInt(reader.readLine());
        int k = Integer.parseInt(reader.readLine());
        
        int count = 0;
        
        switch (k) {
            case 2:
                count = Math.max(right - Math.max(left, 3) + 1, 0);
                break;
            case 3:
                int min3 = Math.max(left, 6);
                int firstMultiple = min3 + (3 - min3 % 3) % 3;
                if (firstMultiple <= right) {
                    count = (right - firstMultiple) / 3 + 1;
                }
                break;
            case 4:
                int min4 = Math.max(left, 10);
                if (min4 % 2 == 1) min4++;
                if (right >= min4) {
                    count = (right - min4) / 2 + 1;
                    if (12 >= min4 && 12 <= right) count--;
                }
                break;
            case 5:
                int min5 = Math.max(left, 15);
                int firstMult5 = min5 + (5 - min5 % 5) % 5;
                if (firstMult5 <= right) {
                    count = (right - firstMult5) / 5 + 1;
                }
                break;
            default:
                throw new AssertionError("k range error");
        }
        
        writer.write(count + "\n");
        writer.flush();
    }
}