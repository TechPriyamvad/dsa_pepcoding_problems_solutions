import java.io.*;
import java.util.*;

public class postfixEvaluationAndConversions{
  

public static void main(String[] args){
    
    Scanner scn = new Scanner(System.in);
    String exp = scn.nextLine();
    postfixEvaluationAndConversions(exp);
 }
 
 public static void postfixEvaluationAndConversions(String exp)
 {
     //store result of expression in integer form
     Stack<Integer> evaluation = new Stack<>();
     
     //store result of expression in prefix form
     Stack<String> prefix = new Stack<>();
     
     //store result of expression in infiox form
     Stack<String> infix = new Stack<>();
     
     //iterate through string
     for(int idx=0;idx < exp.length();idx++)
     {
         char ch = exp.charAt(idx);
         
         //if current charcter is an operator
         if(ch=='+' || ch=='-' || ch=='*' || ch=='/')
         {
             //evaluate expression
             int v2 = evaluation.pop();
             int v1 = evaluation.pop();
             
             //push resultant value of operation between v1 and v2 on stack
             evaluation.push(evaluate(v1,v2,ch));
             
             //evaluate prefix expression
             String p2 = prefix.pop();
             String p1 = prefix.pop();
             
             //push resultant value of operation between p1 and p2 on stack
             prefix.push(ch+p1+p2);
             
             //evaluate infix expression
             String i2 = infix.pop();
             String i1 = infix.pop();
             
             //push resultant value of operation between i1 and i2 on stack
             infix.push("("+i1+ch+i2+")");
             
         }
         
         //if currentg character is operand
         else
         {
             //push character to stack in integer form
             evaluation.push(Integer.parseInt(ch+""));
             
             //push character to stack in string form
             prefix.push(ch+"");
             
             //push character to stack in string form
             infix.push(ch+"");
         }
     }
     
     System.out.println(evaluation.peek());
     System.out.println(infix.peek());
     System.out.print(prefix.peek());
     
 }
 
 public static int evaluate(int op1,int op2,char op)
 {
     if(op=='+')
     {
         return op1 + op2;
     }
     else if(op=='*')
     {
         return op1 * op2; 
     }
     else if(op=='/')
     {
         return op1/op2;
     }
     else
     {
         return op1-op2;
     }
 }
 
 
}