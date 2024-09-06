import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//무한루프
		while(true) {
			String S = br.readLine();
			
			//0입력시 무한루프 종료
			if(S.equals("0")) break;
			
			//무한루프
			while(true) {
				//자릿수의 수들을 합쳐서 저장할 변수
				int sum = 0;
				
				//문자열 길이가 1이 되면 무한루프 종료
				if(S.length() < 2) {
					break;
				}else {
					for(int i = 0; i < S.length(); i++) {
						sum += S.charAt(i) - '0';
					}
				}
				//합을 문자열에 형변환해서 저장
				S = String.valueOf(sum);
			}
			System.out.println(S);
		}
	}

}