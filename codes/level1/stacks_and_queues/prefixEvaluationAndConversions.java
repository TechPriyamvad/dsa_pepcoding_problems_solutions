import java.io.*;
import java.util.*;

public class prefixEvaluationAndConversions{
  

public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    String exp = scn.nextLine();

    prefixToPostfixConversions(exp);
 }
 
 public static void prefixToPostfixConversions(String exp)
 {
     // to store value in integer form
    Stack<Integer> evaluation = new Stack<>();
    
    //to store value as string
    Stack<String> postfix = new Stack<>();
    
    //to store value as string
    Stack<String> infix = new Stack<>();
    
    //iterate over string
    for(int idx = exp.length()-1;idx >= 0;idx--)
    {
        //store current character
        char ch = exp.charAt(idx);
        
        //if character found is operator
        if(ch=='+' || ch=='-' || ch=='*' || ch=='/')
        {
            //evaluation stack arithmetic
            int v1 = evaluation.pop();
            int v2 = evaluation.pop();
            
            evaluation.push(evaluate(v1,v2,ch));
            
            //postfix stack arithmetic
            String p1 = postfix.pop(),p2 = postfix.pop();
            postfix.push(p1+p2+ch);
            
            //infix stack arithmetic
            String i1 = infix.pop(),i2 = infix.pop();
            infix.push("("+i1+ch+i2+")");
        }
        
        //if character found is operand
        else
        {
            evaluation.push(Integer.parseInt(ch+""));
            postfix.push(ch+"");
            infix.push(ch+"");
        }
    }
    
    System.out.println(evaluation.peek());
    System.out.println(infix.peek());
    System.out.println(postfix.peek());
    
 }
 
 public static int evaluate(int v1,int v2,char op)
 {
     if(op=='+')
     {
         return v1+v2;
     }
     else if(op=='-')
     {
         return v1-v2;
     }
     else if(op=='*')
     {
         return v1*v2;
     }
     else
     {
         return v1/v2;
     }
 }
}