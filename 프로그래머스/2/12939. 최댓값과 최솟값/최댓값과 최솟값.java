import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String answer = "";
        int count = s.split(" ").length; //숫자의 갯수
		int[] num = new int[count];
		
		for(int i=0;i<count;i++)
		{
			num[i] = Integer.parseInt(s.split(" ")[i]);
		}
		
		Arrays.sort(num);
		
		answer += num[0] + " " +num[count-1];
        return answer;
    }
}