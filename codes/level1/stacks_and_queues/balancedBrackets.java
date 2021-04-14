import java.io.*;
import java.util.*;

public class balancedBrackets{

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String exp = scn.nextLine();
        System.out.print(balancedBracket(exp));
    }
    
    public static boolean balancedBracket(String exp)
    {
        //creation and memory allocation for stack
        Stack<Character> st = new Stack<>();
        
        //iterate through string
        for(int idx=0;idx < exp.length();idx++)
        {
            char ch = exp.charAt(idx);
            
            //if brackets are opening brackets
            if(ch=='('||ch=='{' || ch=='[')
            {
                st.push(ch);
            }
            
            //if brackets are closing brackets
            else if(ch == ')' || ch == '}' || ch== ']')
            {
                //if closing brackets are more than opening brackets
                if(st.size() == 0)
                {
                    return false;
                }
                
                //if order of brackets is same
                if(ch == ')')
                {
                    //if order of brackets is same
                    if(st.peek() == '(')
                    {
                        st.pop();
                    }
                    //if order of brackets is different
                    else
                    {
                        return false;
                    }
                }
                
                
                if(ch == '}')
                {
                    //if order of brackets is same
                    if(st.peek() == '{')
                    {
                        st.pop();
                    }
                    //if order of brackets is different
                    else
                    {
                        return false;
                    }
                }
                
                //if order of brackets is same
                if(ch == ']')
                {
                    //if order of brackets is same
                    if(st.peek() == '[')
                    {
                        st.pop();
                    }
                    //if order of brackets is different
                    else
                    {
                        return false;
                    }
                }
            }
        }
        
        //number of opening brackets are greater than closing brackets
        if(st.size() != 0)
        {
            return false;
        }
        return true;
    }
}