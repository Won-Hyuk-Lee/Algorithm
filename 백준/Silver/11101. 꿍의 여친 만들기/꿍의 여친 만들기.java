import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    private int getMinimumValue(String a, String b) {
        StringTokenizer st = new StringTokenizer(a, ":, ");
        HashMap<String, Integer> valueMap = new HashMap<>();
        
        while (st.hasMoreTokens()) {
            valueMap.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }
        
        st = new StringTokenizer(b, "| ");
        int minValue = Integer.MAX_VALUE;
        
        while (st.hasMoreTokens()) {
            StringTokenizer tempTokens = new StringTokenizer(st.nextToken(), "& ");
            int maxValue = -1;
            
            while (tempTokens.hasMoreTokens()) {
                maxValue = Math.max(maxValue, valueMap.get(tempTokens.nextToken()));
            }
            
            minValue = Math.min(maxValue, minValue);
        }
        
        return minValue;
    }
    
    private void processInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        StringBuilder resultBuilder = new StringBuilder();
        
        while (testCases-- > 0) {
            resultBuilder.append(getMinimumValue(br.readLine(), br.readLine())).append('\n');
        }
        
        System.out.print(resultBuilder);
    }
    
    public static void main(String[] args) throws Exception {
        new Main().processInput();
    }
}