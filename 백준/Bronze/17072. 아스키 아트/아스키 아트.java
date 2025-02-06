import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ySize = Integer.parseInt(st.nextToken());
        int xSize = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        
        for (int y = 0; y < ySize; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < xSize; x++) {
                int red = Integer.parseInt(st.nextToken());
                int green = Integer.parseInt(st.nextToken());
                int blue = Integer.parseInt(st.nextToken());
                int intensity = 2126 * red + 7152 * green + 722 * blue;
                char ch;
                if (intensity >= 2040000) {
                    ch = '.';
                } else if (intensity >= 1530000) {
                    ch = '-';
                } else if (intensity >= 1020000) {
                    ch = '+';
                } else if (intensity >= 510000) {
                    ch = 'o';
                } else {
                    ch = '#';
                }
                sb.append(ch);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
