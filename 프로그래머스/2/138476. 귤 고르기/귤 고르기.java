import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int sum = 0; // 고를 귤의 갯수
        int cnt = 0; // 최소 종류 카운트
        
        // 귤을 종류별로 저장할 해시맵
        HashMap<Integer, Integer> map = new HashMap<>();
        // 귤의 개수를 해시맵에 n번 넣기 O(n)
        for (int num : tangerine) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        // 귤의 갯수들을 리스트로 변환 후 내림차순O(n log n)
        List<Integer> valueList = new ArrayList<>(map.values());
        Collections.sort(valueList, Collections.reverseOrder());
        
        // 가장 많은 개수의 귤부터 선택 O(n)
        for (int v : valueList) {
            if (sum + v >= k) {
                cnt++;
                break;
            } else {
                sum += v;
                cnt++;
            }
        }
        
        return cnt;
    }
}
