import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int targetNumber = Integer.parseInt(br.readLine());  //목표값
        int smallestConstructor = 0;  //가장작은생성자

        //타겟 숫자 생성자는 타겟 숫자 최대값에서 9 X 자릿수 값을 뺀 값부터 시작함
        for (int i = Math.max(1, targetNumber - 9 * String.valueOf(targetNumber).length()); i < targetNumber; i++) {
            int currentNumber = i;
            int sumOfDigits = i;

            //각 자릿수++
            while (currentNumber != 0) {
                sumOfDigits += currentNumber % 10;
                currentNumber /= 10;
            }

            //생성자 맞는지 확인하기
            if (sumOfDigits == targetNumber) {
                smallestConstructor = i;
                break;
            }
        }

        System.out.println(smallestConstructor);
        br.close();
    }
}
