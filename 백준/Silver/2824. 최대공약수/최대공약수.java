import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Map<Integer, Integer> aMap = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) getFactors(Integer.parseInt(st.nextToken()), aMap);

		int m = Integer.parseInt(br.readLine());
		Map<Integer, Integer> bMap = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) getFactors(Integer.parseInt(st.nextToken()), bMap);

		long gcd = 1L;
		boolean flag = false;

		for (int key : aMap.keySet()) {
			if (bMap.containsKey(key)) {
				int min = Math.min(aMap.get(key), bMap.get(key));
				for (int i = 0; i < min; i++) {
					gcd *= key;
					if (gcd >= 1_000_000_000) {
						gcd %= 1_000_000_000;
						flag = true;
					}
				}
			}
		}
		System.out.println(flag ? String.format("%09d", gcd) : gcd);
	}

	static void getFactors(int num, Map<Integer, Integer> map) {
		for (int i = 2; i * i <= num; i++) {
			while (num % i == 0) {
				map.put(i, map.getOrDefault(i, 0) + 1);
				num /= i;
			}
		}
		if (num > 1) map.put(num, map.getOrDefault(num, 0) + 1);
	}
}
