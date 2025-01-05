import java.io.*;
import java.util.*;

public class Main {
    static int gridSize, patternCount = 0;
    static final int PATTERN_LENGTH = 4;
    static final int[] MOVE_RIGHT = {1, 2, 3, 4};
    static final int[] MOVE_UP = {-1, -2, -3, -4};
    static final int[] MOVE_DOWN = {1, 2, 3, 4};
    static final char[] MOBIS_PATTERN = {'O', 'B', 'I', 'S'};
    static final char[] SIBOM_PATTERN = {'I', 'B', 'O', 'M'};
    static char[][] grid;
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        gridSize = Integer.parseInt(reader.readLine());
        grid = new char[gridSize][gridSize];
        
        for (int row = 0; row < gridSize; row++) {
            String line = reader.readLine();
            for (int col = 0; col < gridSize; col++) {
                grid[row][col] = line.charAt(col);
            }
        }
        
        searchPatterns();
        
        writer.write(String.valueOf(patternCount));
        writer.flush();
        writer.close();
        reader.close();
    }
    
    private static void searchPatterns() {
        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                if (grid[row][col] == 'M') {
                    findMobis(row, col);
                } else if (grid[row][col] == 'S') {
                    findSibom(row, col);
                }
            }
        }
    }
    
    private static void findMobis(int row, int col) {
        searchDirection(row, col, MOVE_UP, MOVE_RIGHT, MOBIS_PATTERN);
        searchDirection(row, col, new int[PATTERN_LENGTH], MOVE_RIGHT, MOBIS_PATTERN);
        searchDirection(row, col, MOVE_DOWN, MOVE_RIGHT, MOBIS_PATTERN);
        searchDirection(row, col, MOVE_DOWN, new int[PATTERN_LENGTH], MOBIS_PATTERN);
    }
    
    private static void findSibom(int row, int col) {
        searchDirection(row, col, MOVE_UP, MOVE_RIGHT, SIBOM_PATTERN);
        searchDirection(row, col, new int[PATTERN_LENGTH], MOVE_RIGHT, SIBOM_PATTERN);
        searchDirection(row, col, MOVE_DOWN, MOVE_RIGHT, SIBOM_PATTERN);
        searchDirection(row, col, MOVE_DOWN, new int[PATTERN_LENGTH], SIBOM_PATTERN);
    }
    
    private static void searchDirection(int startRow, int startCol, int[] rowMoves, int[] colMoves, char[] pattern) {
        int currentRow = startRow;
        int currentCol = startCol;
        
        for (int i = 0; i < PATTERN_LENGTH; i++) {
            int nextRow = currentRow + rowMoves[i];
            int nextCol = currentCol + colMoves[i];
            
            if (!isValidPosition(nextRow, nextCol) || grid[nextRow][nextCol] != pattern[i]) {
                return;
            }
        }
        patternCount++;
    }
    
    private static boolean isValidPosition(int row, int col) {
        return row >= 0 && col >= 0 && row < gridSize && col < gridSize;
    }
}