import java.util.Arrays;
import java.util.Scanner;

class Main {
    static int[] nums;
    static int[] arr;
    static boolean[] isVisited; 
    static int N; 
    static int M; 
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); //숫자 배열 크기
        M = sc.nextInt(); //조합 길이
        nums = new int[N];
        arr = new int[M]; //M크기 배열로
        isVisited = new boolean[N];
        
        //숫자 배열 입력
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums); //오름차순 정렬 사전순 조합
        
        dfs(0); //DFS
        System.out.println(sb.toString());
    }

    private static void dfs(int depth) {
        if (depth == M) { 
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for (int i = 0; i < N; i++) {
            if (!isVisited[i]) { 
                isVisited[i] = true;
                arr[depth] = nums[i]; //현재 깊이 숫자 선택
                dfs(depth + 1); //다음 깊이로
                isVisited[i] = false; //해당 숫자를 미사용 상태로
            }
        }
    }
}
