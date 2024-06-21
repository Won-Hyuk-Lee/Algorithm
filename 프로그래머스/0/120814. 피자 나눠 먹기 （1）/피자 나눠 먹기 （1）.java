class Solution {
    public int solution(int n) {
        int answer = 1;
        while (n > 7)
        {
            answer++;
            n-=7;
        }
        return answer;
    }
}