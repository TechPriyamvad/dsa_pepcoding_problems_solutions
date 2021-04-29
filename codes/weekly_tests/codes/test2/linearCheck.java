import java.util.Scanner;

public class linearCheck {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        
        int arr[] = new int[n*2];
        
        for(int idx=0;idx < arr.length;idx++)
        {
            arr[idx] = scn.nextInt();
        }
        
        boolean res = linearCheck(arr);
        if(res)
        {
            System.out.print("YES");
        }
        else
        {
            System.out.print("NO");
        }
    }
    
    public static boolean linearCheck(int inp[])
    {
        boolean res = false;
        
        for(int i=0,j=1;j < inp.length;i+=2,j+=2)
        {
            if(inp[i]==0 || inp[j] == 0)
            {
                res = true;
            }
            else
            {
                res = false;
                break;
            }
        }
        
        return res;
    }
}