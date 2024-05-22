import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt(); //횟수 입력
		int total = 0; // 총합 초기화
		ArrayList<Integer> nums = new ArrayList<Integer>(); //Integer형의 list생성
		for (int i = 0; i < num; i++)
		{
			nums.add(sc.nextInt()); // 리스트에 값 입력
		}
		                 // 값이 낮은 값부터
                         // 앞에서 실행해야 시간이 줄어들기에
		nums.sort(null); // 오름차순으로 정렬
		
		for (int i = 0; i < num; i++)
        {
            for (int j = 0; j <= i; j++)
            {
                total += nums.get(j); //2중 for문으로 총 대기시간을 합산
            }
        }
		System.out.println(total);
	}
}