import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> A = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            String[] tokens = br.readLine().split(" ");
            List<Integer> row = new ArrayList<>();
            for (String token : tokens) {
                row.add(Integer.parseInt(token));
            }
            A.add(row);
        }
        
        int pos = 1;
        for (int i = 0; i < N; i++) {
            int next = 0;
            List<Integer> currentRow = A.get(i);
            
            if (pos <= 13) {
                int leftSum = 0;
                for (int j = 0; j < currentRow.size(); j++) {
                    if (j % 2 == 0) {
                        next += currentRow.get(j);
                    } else {
                        if (leftSum + currentRow.get(j) >= pos) {
                            next += pos - leftSum;
                            break;
                        } else {
                            next += currentRow.get(j);
                            leftSum += currentRow.get(j);
                        }
                    }
                }
            } else {
                int adjustedPos = pos - 13;
                int rightSum = 0;
                for (int j = 0; j < currentRow.size(); j++) {
                    if (j % 2 == 1) {
                        next += currentRow.get(j);
                    } else {
                        if (rightSum + currentRow.get(j) >= adjustedPos) {
                            next += adjustedPos - rightSum;
                            break;
                        } else {
                            next += currentRow.get(j);
                            rightSum += currentRow.get(j);
                        }
                    }
                }
            }
            pos = next;
        }
        
        System.out.println(pos);
    }
}