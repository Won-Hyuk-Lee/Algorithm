import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int count = Integer.parseInt(br.readLine());

    int[] current = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int[] target = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int ans = 0;
    for (int i = 0; i < count; i++) {
      int calc = target[i] - current[i];
      if (calc > 0) {
        ans += Math.abs(calc);
      }
    }
    System.out.println(ans);
  }
}