import java.io.*;
import java.util.*;

public class climbStairs {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        //System.out.println(countStairs(n));
        System.out.println(countStairsTabulation(n));
    }
    
    public static int countStairs(int n)
    {
        //base case
        if(n==0)
        {
            return 1;
        }
        
        int csM1=0,csM2=0,csM3=0;
        if( n-1 >= 0)
        {
            //1 len jump
            csM1 = countStairs(n-1);
        }
        
        if(n-2 >= 0)
        {
            //2 len jump
            csM2 = countStairs(n-2);
        }
        
        if(n-3 >= 0)
        {
            //3 len jump
            csM3 = countStairs(n-3);
        }
        
        int csN = csM1 + csM2 + csM3;
        
        return csN;
    }
    
    public static int countStairsMemoise(int n,int qb[])
    {
        //base case
        if(n==0)
        {
            return 1;
        }
        
        //calling a function not first time
        if(qb[n] > 0)
        {
            //
            return qb[n];
        }
        
        int csM1=0,csM2=0,csM3=0;
        if( n-1 >= 0)
        {
            //1 len jump
            csM1 = countStairs(n-1);
        }
        
        if(n-2 >= 0)
        {
            //2 len jump
            csM2 = countStairs(n-2);
        }
        
        if(n-3 >= 0)
        {
            //3 len jump
            csM3 = countStairs(n-3);
        }
        
        int csN = csM1 + csM2 + csM3;
        qb[n]=csN;
        return csN;
    }
    
    public static int countStairsTabulation(int n)
    {
        int dp[] = new int[n+1];
        
        dp[0] = 1;
        
        for(int i=1;i <= n;i++)
        {
            if(i==1)
            {
                dp[i] = dp[i-1];
            }
            else if(i==2)
            {
                dp[i] = dp[i-1] + dp[i-2];
            }
            else
            {
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }
            
        }
        
        return dp[n];
    }
    
}