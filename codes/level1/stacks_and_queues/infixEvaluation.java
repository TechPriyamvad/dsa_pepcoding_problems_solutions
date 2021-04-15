import java.io.*;
import java.util.*;

public class infixEvaluation{
  
public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    String exp = scn.nextLine();
    infix(exp);
 }
 
 public static void infix(String exp)
 {
     //store operand on operan stack
     Stack<Integer> operand = new Stack<>();
     
     //store operator on operator stack
     Stack<Character> operator = new Stack<>();
     
     //itearte through string
     for(int idx=0;idx < exp.length();idx++)
     {
         //find current character
         char ch = exp.charAt(idx);
         
         //when current operator opening brackets
         if(ch == '(')
         {
             operator.push(ch);
         }
         
         //when current charcter is operator
         else if(ch=='+' || ch=='-' || ch == '*' || ch=='/')
         {
             while(operator.size() > 0 && operator.peek() != '(' && precedence(ch) <= precedence(operator.peek()))
             {
                 char op = operator.pop();
                 int v2 = operand.pop(),v1 = operand.pop();
                 operand.push(evaluate(v1,v2,op));
             }
             
             operator.push(ch);
         }
         else if(ch >= '0' && ch <= '9')
         {
             operand.push(Integer.parseInt(ch+""));
         }
         else if(ch == ')')
         {
             while(operator.peek() != '(')
             {
                 char op = operator.pop();
                 int v2 = operand.pop(),v1 = operand.pop();
                 operand.push(evaluate(v1,v2,op));
             }
             operator.pop();//removing opening bracket
         }
     }
     
     while(operator.size()>0)
     {
         char op = operator.pop();
         int v2 = operand.pop();
         int v1 = operand.pop();
         operand.push(evaluate(v1,v2,op));
     }
     
     System.out.println(operand.peek());
 }
 
 public static int precedence(char ch)
 {
     if(ch == '+' || ch == '-')
     {
         return 2;
     }
     else
     {
         //ch -> '\','*'
         return 4;
     }
 }
 
 public static int evaluate(int v1,int v2,char op)
 {
     if(op == '+')
     {
         return v1+v2;
     }
     else if(op == '-')
     {
         return v1-v2;
     }
     else if(op == '*')
     {
         return v1*v2;
     }
     else 
     {
         return v1/v2;
     }
 }
 
 
}
 
 
 
 
 
 
 
 
 
 
 
