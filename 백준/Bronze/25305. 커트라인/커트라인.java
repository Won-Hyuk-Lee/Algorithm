import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int people = sc.nextInt(); // 참가자수
		int winner = sc.nextInt(); // 수상자수

		int[] challenger = new int[people]; // 도전자 배열

		for (int i = 0; i < people; i++) {
			challenger[i] = sc.nextInt(); // 도전자 배열에 전체 참가자 삽입
		}

		Arrays.sort(challenger); // 오름차순상태

		System.out.println(challenger[people - winner]); // 커트라인

	}

}