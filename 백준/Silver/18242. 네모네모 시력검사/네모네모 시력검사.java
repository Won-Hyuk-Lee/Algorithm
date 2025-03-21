import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int cs = 0, cnt = 0;
        for (int i = 0; i < r; i++) {
            String tmp = br.readLine();
            if (!tmp.contains("#")) continue;

            cs = tmp.indexOf('#');
            cnt = 1;
            for (int j = cs + 1; j < c && tmp.charAt(j) == '#'; j++) {
                cnt++;
            }

            if (cnt != tmp.lastIndexOf('#') - cs + 1) {
                System.out.println("UP");
                return;
            }
            break;
        }

        for (int i = 0; i < (cnt - 2) / 2; i++) br.readLine();

        String tmp = br.readLine();
        if (tmp.charAt(cs) == '#' && tmp.charAt(cs + cnt - 1) == '#') {
            System.out.println("DOWN");
        } else if (tmp.charAt(cs) == '#') {
            System.out.println("RIGHT");
        } else {
            System.out.println("LEFT");
        }
    }
}
