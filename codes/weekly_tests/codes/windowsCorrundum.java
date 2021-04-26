import java.io.*;
import java.util.*;

public class windowsCorrundum {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int arr[] = new int[n];
        
        for(int idx=0;idx < arr.length;idx++)
        {
            arr[idx] = scn.nextInt();
        }
        
        int k = scn.nextInt();
        
        windowsConundrum(arr,k);
    }
    
    public static void windowsConundrum(int arr[],int k)
    {
        Queue<Integer> res = new ArrayDeque<>();
        for(int idx=0;idx < arr.length;idx++)
        {
            int max = Integer.MIN_VALUE;
            if(idx+k <= arr.length)
            {
                //maximum value in window
                for(int w = idx; w < idx + k ;w++)
                {
                    int val = arr[w];
                    if(val >= max)
                    {
                        max = val;
                    }
                }
                res.add(max);
            }
            else
            {
                break;
            }
            
        }
        
        while(res.size() > 0)
        {
            System.out.println(res.remove());
        }
    }
}