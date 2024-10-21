import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people); //몸무게 오름차순
        int count = 0;
        int left = 0;
        int right = people.length - 1;
        
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                //가장 가벼운 사람 + 가장 무거운 사람 함께 태우는 경우
                left++;
                right--;
            } else {
                //가장 무거운 사람만 태우는 경우
                right--;
            }
            count++;
        }
        
        return count;
    }
}