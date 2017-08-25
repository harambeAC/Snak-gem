

import java.util.LinkedList;
import java.util.Random;

public class GameModel {
    
    public static final int WIDTH = 21;
    public static final int HEIGHT = 13;
    
    public static final int HEAD = 0;
    
    public static final int[][] DIRS =  {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    
    public int[][] grid;
    
    public LinkedList<int[]> pieces;
    public Random r;
    
    public int dir;
    public boolean gameOver;
    
    
    public GameModel() {
        grid = new int[HEIGHT][WIDTH];
        grid[HEIGHT / 2][WIDTH / 2] = 1;
        
        pieces = new LinkedList<>();
        pieces.add(new int[]{HEIGHT / 2, WIDTH / 2});
        
        dir = 0;
        
        r = new Random();
        insertFood();
    }
    
    public void move() {
        if (!gameOver) {
            int row = pieces.get(HEAD)[0] + DIRS[dir][0];
            int col = pieces.get(HEAD)[1] + DIRS[dir][1];
            
            if (!inBounds(row, col) || grid[row][col] == 1) {
                gameOver = true;
                return;
            }
            
            boolean ateFood = grid[row][col] == 2;
            
            grid[row][col] = 1;
            
            if (ateFood) {
                pieces.add(null);
                insertFood();
            } else {
                grid[tailRow()][tailCol()] = 0;
            }
            
            pieces.add(0, new int[]{row, col});
            pieces.remove(pieces.size() - 1);
        }
    }
    
    private void insertFood() {
        int row = r.nextInt(HEIGHT);
        int col = r.nextInt(WIDTH);
        while (occupied(row, col)) {
            row = r.nextInt(HEIGHT);
            col = r.nextInt(WIDTH);
        }
        grid[row][col] = 2;
    }
    
    private boolean occupied(int row, int col) {
        return grid[row][col] != 0;
    }
    
    private int tailRow() {
        return pieces.get(pieces.size() - 1)[0];
    }
    
    private int tailCol() {
        return pieces.get(pieces.size() - 1)[1];
    }
    
    private boolean inBounds(int row, int col) {
        return row >= 0 && row < grid.length &&
               col >= 0 && col < grid[0].length;
    }
}