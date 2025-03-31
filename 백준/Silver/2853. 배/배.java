import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] day = new int[N];
		for (int i = 0; i < N; i++) {
			day[i] = Integer.parseInt(br.readLine());
		}

		int answer = 0;

		for (int i = 1; i < N; i++) {
			if (day[i] == 0) continue;

			int interval = day[i] - day[0];
			boolean found = false;

			for (int j = 1; j < N; j++) {
				if (day[j] != 0 && day[j] % interval == 1) {
					found = true;
					day[j] = 0;
				}
			}

			if (found) answer++;
		}

		System.out.println(answer);
	}
}
