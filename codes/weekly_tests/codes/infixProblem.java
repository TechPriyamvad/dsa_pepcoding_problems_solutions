import java.util.Scanner;
import java.util.Stack;

public class infixProblem{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String exp = scn.nextLine();
        infixSolver(exp);
    }
    
    public static void infixSolver(String exp)
    {
        Stack<Integer>   numberExp   = new Stack<>();
        Stack<String>    postfixExp  = new Stack<>();
        Stack<String>    prefixExp   = new Stack<>();
        Stack<Character> operatorExp = new Stack<>();
        
        for(int idx=0;idx < exp.length();idx++)
        {
            //get current character
            char ch = exp.charAt(idx);
            
            //character is operator
            if(ch == '+' || ch=='-' || ch=='*' || ch == '/')
            {
                //System.out.println(ch);
                while(operatorExp.size() > 0 && (priority(ch) <= priority(operatorExp.peek())))
                {
                    char input = operatorExp.pop();
                    //evaluate number stack
                    int n2 = numberExp.pop();
                    int n1 = numberExp.pop();
                    int rn = operation(input,n1,n2);
                    numberExp.push(rn);
                    
                    //evaluate postfix stack
                    String po2 = postfixExp.pop();
                    String po1 = postfixExp.pop();
                    postfixExp.push(po1+po2+(input+""));
                    
                    //evaluate prefix stack
                    String pr2 = prefixExp.pop();
                    String pr1 = prefixExp.pop();                    
                    prefixExp.push((input+"")+pr1+pr2);
                }
                operatorExp.push(ch);
            }
            //character is operand
            else if(ch == ' ' || (ch >='a' && ch <= 'z')||(ch>='A' && ch <= 'Z'))
            {
                
            }
            else
            {
                numberExp.push(Integer.parseInt(ch+""));
                postfixExp.push(ch+"");
                prefixExp.push(ch+"");
            }
        }
        
        while(operatorExp.size() > 0)
        {
            char ch = operatorExp.pop();
            
                    //evaluate number stack
                    int n2 = numberExp.pop();
                    int n1 = numberExp.pop();
                    int rn = operation(ch,n1,n2);
                    numberExp.push(rn);
                    
                    //evaluate postfix stack
                    String po2 = postfixExp.pop();
                    String po1 = postfixExp.pop();
                    postfixExp.push(po1+po2+(ch+""));
                    
                    //evaluate prefix stack
                    String pr2 = prefixExp.pop();
                    String pr1 = prefixExp.pop();
                    prefixExp.push((ch+"")+pr1+pr2);
        }
        
        System.out.println(numberExp.peek());
        System.out.println(postfixExp.peek());
        System.out.println(prefixExp.peek());
    }
    
    public static int operation(char ch,int n1,int n2)
    {
        if(ch == '+')
        {
            return n1 + n2;
        }
        else if(ch == '-')
        {
            return n1 - n2;
        }
        else if(ch == '*')
        {
            return n1 * n2;
        }
        else
        {
            return n1 / n2;
        }
    }
    public static int priority(char input)
    {
        if(input == '+' || input=='-')
        {
            return 2;
        }
        else
        {
            return 4;
        }
    }
}