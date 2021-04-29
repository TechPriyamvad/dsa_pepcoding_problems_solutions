import java.io.*;
import java.util.*;

public class fashionShow {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int inp[] = new int[n];
        for(int idx=0;idx < n;idx++)
        {
            inp[idx] = scn.nextInt();
        }
        
        fashionShow(inp);
    }
    
    public static void fashionShow(int[] res)
    {
        boolean flag = false;
        for(int i=0,j=1;j < res.length;i++,j++)
        {
            //to find smaller
            if(flag==false)
            {
                //swap
                if(res[i] > res[j])
                {
                    int tmp = res[i];
                    res[i] = res[j];
                    res[j] = tmp;
                }
                flag=true;
                continue;
            }
            
            //to find larger
            if(flag==true)
            {
                //swap
                if(res[i] < res[j])
                {
                    int tmp = res[i];
                    res[i] = res[j];
                    res[j] = tmp;
                }
                flag=false;
                continue;
            }
        }
        
        for(int val : res)
        {
            System.out.print(val + " ");
        }
    }
}