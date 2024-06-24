import java.util.Arrays;

class Solution {
	public int solution(int n, int[] lost, int[] reserve) {
       
		//학생들의 체육복 상태 배열
        int[] students = new int[n];
        Arrays.fill(students, 1); //전부 1로 초기화
        
        //도난당한 학생들의 체육복을 0으로
        for (int l : lost) {
            students[l - 1]--;
        }
        
        //여벌 체육복이 있는 학생들의 체육복을 2로
        for (int r : reserve) {
            students[r - 1]++;
        }
        
        //체육복을 빌려줄 수 있는지 확인
        for (int i = 0; i < n; i++) {
            if (students[i] == 0) //체육복 긴빠이 당했으면?
            { 
                if (i > 0 && students[i - 1] == 2) { //앞 번호 학생에게 빌릴 수 있지 먼저 확인
                    students[i]++;
                    students[i - 1]--;
                } else if (i < n - 1 && students[i + 1] == 2) { //그게 아니면 뒷 번호 학생에게 빌릴 수 있는지 확인
                    students[i]++;
                    students[i + 1]--;
                }
            }
        }
        
        //체육수업을 들을 수 있는 학생 수
        int count = 0;
        for (int s : students) {
            if (s > 0) {
                count++;
            }
        }
        
        return count;
    }
}