import java.io.*;
import java.util.*;

public class printNQueens {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printNQueens(new int[n][n],"",0);
        
    }

    public static void printNQueens(int[][] chess, String qsf, int row) {
        
        //each row is visited
        //print configuration
        if(row == chess.length)
        {
            System.out.println(qsf+".");
            return;
        }
        
        for(int col=0;col < chess[0].length;col++)
        {
            if(isSafe(chess,row,col))
            {
                //mark cell
                chess[row][col]=1;
                
                //move to next row
                printNQueens(chess,qsf+row+"-"+col+", ",row+1);
                
                //unmark cell
                chess[row][col]=0;
            }
        }
    }
    
    //checks whether it is safe to place queen or not
    //check previous left diagonals,right diagonals and previous top rows
    public static boolean isSafe(int[][] chess,int row,int col)
    {
        //check in previous rows
        for(int r=row-1,c=col;r >= 0;r--)
        {
            if(chess[r][c]==1)
                return false;
        }
        
        //check in previous right diagonals
        for(int r=row-1,c=col+1;r>=0&& c<chess[0].length;r--,c++)
        {
            if(chess[r][c]==1)
                return false;
        }
        
        //check previous left diagonals
        for(int r=row-1,c=col-1;r>=0 && c>=0;r--,c--)
        {
            if(chess[r][c]==1)
                return false;
        }
        
        return true;
    }
}