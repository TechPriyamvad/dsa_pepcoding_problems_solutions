import java.io.*;
import java.util.*;

public class printKnightsTour {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int r = scn.nextInt();
        int c = scn.nextInt();
        printKnightsTour(new int[n][n],r,c,1);
    }

    public static void printKnightsTour(int[][] chess, int r, int c, int upcomingMove) {
        
        int nr = chess.length;
        int nc = chess[0].length;
        
        //edge cases
        if(r<0 || c<0 || r >= chess.length || c >= chess[0].length || chess[r][c]!=0)
        {
            return;
        }
        
        //when all cells of chess board are marked
        //on last cell
        if(nr*nc==upcomingMove)
        {
            chess[r][c]=upcomingMove;
            displayBoard(chess);
            chess[r][c]=upcomingMove;
        }
        
        //mark cell as visited
        chess[r][c]=upcomingMove;
        
        //explore 8 directions in which knight can move
        printKnightsTour(chess, r-2,c+1,upcomingMove+1);//dir 1
        printKnightsTour(chess, r-1,c+2,upcomingMove+1);//dir 2
        printKnightsTour(chess, r+1,c+2,upcomingMove+1);//dir 3
        printKnightsTour(chess, r+2,c+1,upcomingMove+1);//dir 4
        printKnightsTour(chess, r+2,c-1,upcomingMove+1);//dir 5
        printKnightsTour(chess, r+1,c-2,upcomingMove+1);//dir 6
        printKnightsTour(chess, r-1,c-2,upcomingMove+1);//dir 7
        printKnightsTour(chess, r-2,c-1,upcomingMove+1);//dir 8
        
        //unmark cell for finding next configueration
        chess[r][c]=0;
    }

    public static void displayBoard(int[][] chess){
        for(int i = 0; i < chess.length; i++){
            for(int j = 0; j < chess[0].length; j++){
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}