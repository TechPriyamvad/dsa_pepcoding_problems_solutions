import java.io.*;
import java.util.*;

public class duplicateBrackets {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String exp = scn.nextLine();
        System.out.print(isDuplicateBrackets(exp));
    }
    
    public static boolean isDuplicateBrackets(String exp)
    {
        Stack<Character> st = new Stack<>();
        
        //iterate through string
        for(int idx=0;idx < exp.length();idx++)
        {
            //fetch character
            char ch = exp.charAt(idx);
            
            //check for duplicate brackets
            if(ch == ')')
            {
                if(st.peek()=='(')
                {
                    return true;
                }
                
                while(st.peek() != '(')
                {
                    st.pop();
                }
                
                st.pop();
            }
            //push character on stack
            else
            {
                st.push(ch);
            }
        }
        
        return false;
    }

}