import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		Stack<int[]> stack = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 각 탑의 높이를 순서대로 처리
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());

			// 스택이 비어 있으면 0을 추가
			if (stack.isEmpty()) {
				sb.append(0).append(" ");
			} else {
				// 스택의 탑들과 비교하여 num보다 큰 탑을 찾음
				while (!stack.isEmpty()) {
					int[] data = stack.peek();
					int towerIndex = data[0];
					int towerHeight = data[1];
					if (towerHeight > num) {
						sb.append(towerIndex).append(" ");
						break;
					} else {
						stack.pop();
					}

					if (stack.isEmpty()) {
						sb.append(0).append(" ");
						break;
					}
				}
			}
			// 현재 탑을 스택에 추가
			stack.push(new int[] { i + 1, num });
		}
		System.out.println(sb.toString());
	}
}