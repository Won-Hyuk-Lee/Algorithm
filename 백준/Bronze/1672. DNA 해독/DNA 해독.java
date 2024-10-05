import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final char[][] DECODE_TABLE = {
        {'A', 'C', 'A', 'G'},
        {'C', 'G', 'T', 'A'},
        {'A', 'T', 'C', 'G'},
        {'G', 'A', 'G', 'T'}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String dna = br.readLine();
        
        char result = dna.charAt(dna.length() - 1);
        for (int i = dna.length() - 2; i >= 0; i--) {
            result = DECODE_TABLE[index(dna.charAt(i))][index(result)];
        }
        
        System.out.println(result);
    }

    private static int index(char c) {
        switch (c) {
            case 'A': return 0;
            case 'G': return 1;
            case 'C': return 2;
            default: return 3; //T
        }
    }
}