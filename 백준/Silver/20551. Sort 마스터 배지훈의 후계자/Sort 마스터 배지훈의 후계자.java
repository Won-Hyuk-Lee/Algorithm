import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {


    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        Map<Integer,Integer> m= new HashMap<>();
        int N=sc.nextInt();
        int M=sc.nextInt();
        int arr[]=new int [N];

        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);

        for(int i=0;i<arr.length;i++){
            if(m.get(arr[i])==null){
                m.put(arr[i],i);
            }
        }

        for(int i=0;i<M;i++){
            int goal=sc.nextInt();
            if(m.get(goal)==null) System.out.println(-1);
            else System.out.println(m.get(goal));
        }
    }
}