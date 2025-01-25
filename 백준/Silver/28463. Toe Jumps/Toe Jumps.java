import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String dir = br.readLine();
        String[] name = {"T", "F", "Lz"};
        char[] T = {'.', 'O', 'P', '.'};
        char[] F = {'I', '.', '.', 'P'};
        char[] Lz = {'O', '.', '.', 'P'};
        boolean[] check = new boolean[3];

        char[] u = br.readLine().toCharArray();
        char[] d = br.readLine().toCharArray();
        char[] j = new char[4];

        switch (dir) {
            case "E":
                j[0] = d[0]; j[1] = u[0]; j[2] = d[1]; j[3] = u[1];
                break;
            case "W":
                j[0] = u[1]; j[1] = d[1]; j[2] = u[0]; j[3] = d[0];
                break;
            case "S":
                j[0] = u[0]; j[1] = u[1]; j[2] = d[0]; j[3] = d[1];
                break;
            case "N":
                j[0] = d[1]; j[1] = d[0]; j[2] = u[1]; j[3] = u[0];
                break;
        }

        for (int i = 0; i < 4; i++) {
            if (!check[0] && j[i] != T[i]) check[0] = true;
            if (!check[1] && j[i] != F[i]) check[1] = true;
            if (!check[2] && j[i] != Lz[i]) check[2] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            if (!check[i]) {
                sb.append(name[i]);
                break;
            }
        }

        bw.write(sb.length() == 0 ? "?" : sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}