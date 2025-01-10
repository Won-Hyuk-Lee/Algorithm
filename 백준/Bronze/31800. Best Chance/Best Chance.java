import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] profits = new int[n];
        int[] prices = new int[n];
        int maxProfit = 0, secondMaxProfit = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            profits[i] = Integer.parseInt(st.nextToken());
            if (profits[i] > maxProfit) {
                secondMaxProfit = maxProfit;
                maxProfit = profits[i];
            } else if (profits[i] > secondMaxProfit) {
                secondMaxProfit = profits[i];
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int opportunityCost = (profits[i] == maxProfit) ? secondMaxProfit - prices[i] : maxProfit - prices[i];
            int netProfit = profits[i] - opportunityCost - prices[i];
            sb.append(netProfit).append(" ");
        }

        System.out.println(sb.toString().trim());
        br.close();
    }
}
