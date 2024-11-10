import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] pValues = new int[n + 1];
		int[] mValues = new int[n + 1];
		Arrays.fill(pValues, -1);
		Arrays.fill(mValues, -1);
		
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			String pm = st.nextToken();
			int ot = Integer.parseInt(st.nextToken());

			if (pm.equals("P")) {
				pValues[num] = ot;
			} else if (pm.equals("M")) {
				mValues[num] = ot;
			}
		}
		
		int min = 0;
		int max = 0;
		
		for (int i = 1; i <= n; i++) {
			if (pValues[i] == 1 && mValues[i] == 0) {
				min++;
			}
			if ((pValues[i] == 1 || pValues[i] == -1) && (mValues[i] == -1 || mValues[i] == 0)) {
				max++;
			}
		}
		
		bw.write(min + " " + max);
		bw.flush();
		br.close();
		bw.close();
	}
}
