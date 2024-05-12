class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        double total = 0;
        for(int i = 0;i<arr.length;i++)
        {
            total += arr[i];
        }
        answer = total/arr.length;
        return answer;
    }
}