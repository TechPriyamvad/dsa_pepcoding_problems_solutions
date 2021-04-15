import java.io.*;
import java.util.*;

public class infixConversion{
  
public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    String exp = scn.nextLine();
    infix(exp);
 }
 
 public static void infix(String exp)
 {
     
     Stack<String> postfix = new Stack<>();
     
     
     Stack<String> prefix = new Stack<>();
     
     Stack<Character> operator = new Stack<>();
     
     //itearte through string
     for(int idx=0;idx < exp.length();idx++)
     {
         //find current character
         char ch = exp.charAt(idx);
         
         
         if(ch == '(')
         {
             operator.push(ch);
         }
         
         
         else if(ch=='+' || ch=='-' || ch == '*' || ch=='/')
         {
             while(operator.size() > 0 && operator.peek() != '(' && precedence(ch) <= precedence(operator.peek()))
             {
                 char op = operator.pop();
                 String po2 = postfix.pop(),po1 = postfix.pop();
                 postfix.push(po1+po2+op);
                 
                 String pr2 = prefix.pop(),pr1 = prefix.pop();
                 prefix.push(op+pr1+pr2);
             }
             operator.push(ch);
         }
         else if(ch >= 'a' && ch <= 'z')
         {
             postfix.push(ch+"");
             prefix.push(ch+"");
         }
         else if(ch == ')')
         {
             while(operator.peek() != '(')
             {
                 char op = operator.pop();
                 String po2 = postfix.pop(),po1 = postfix.pop();
                 postfix.push(po1+po2+op);
                 
                 String pr2 = prefix.pop(),pr1 = prefix.pop();
                 prefix.push(op+pr1+pr2);
             }
             operator.pop();//removing opening bracket
         }
     }
     
     while(operator.size()>0)
     {
         char op = operator.pop();
        String po2 = postfix.pop(),po1 = postfix.pop();
        postfix.push(po1+po2+op);
                 
        String pr2 = prefix.pop(),pr1 = prefix.pop();
        prefix.push(op+pr1+pr2);
     }
     
     System.out.println(postfix.peek());
     System.out.println(prefix.peek());
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
 
 
}
 
 
 
 
 
 
 
 
 
 
 
