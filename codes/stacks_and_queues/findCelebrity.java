import java.io.*;
import java.util.*;

public class findCelebrity {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);

    }

    public static void findCelebrity(int[][] arr) {
        // if a celebrity is there print it's index (not position), if there is not then
        // print "none"
        Stack<Integer> st = new Stack<>();
        
        //push each person index number into stack
        for(int idx=0;idx < arr.length;idx++)
        {
            st.push(idx);
        }
        
        //eleminating disqualified celebrity candidate
        while(st.size() > 1)
        {
            //first person
            int p1 = st.pop();
            
            //second person
            int p2 = st.pop();
            
            //if p1 knows p2
            if(arr[p1][p2] == 1)
            {
                st.push(p2);
            }
            //if p2 knows p1
            else
            {
                st.push(p1);
            }
        }
        
        //possible celebrity candidate
        int pcc = st.pop();
        
        //crosschecking possible celebrity candidate for final celebrity candidature
        
        //rFlag = true : possible celebrity candidate doesn't now every person
        boolean rFlag = true;
        
        //cFlag = true : possible celebrity candidate is known by everyone
        boolean cFlag = true;
        
        //checking celebrity candidate row
        for(int c=0;c <  arr.length;c++)
        {
            if(arr[pcc][c] == 1)
            {
                rFlag = false;
            }
        }
        
        //checking celebrity candidate column
        for(int r=0;r <  arr.length;r++)
        {
            if(arr[pcc][r] == 0 && r != pcc)
            {
                cFlag = false;
            }
        }
        
        //if possible celebrity candidate is not final celebrity candidate
        if(rFlag==false || cFlag==false)
        {
            System.out.println("none");
        }
        //if possible celebrity candidate is final celebrity candidate
        else
        {
            System.out.println(pcc);
        }
        
        
        
        
    }

}