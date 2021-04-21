import java.util.ArrayList;
import java.util.Stack;

public class Main
{
    public static class Node
    {
        int data;
        ArrayList<Node> children;
        
        Node(int data)
        {
            this.data = data;
            children = new ArrayList<>();
        }
    }
    
    public static Node construct(int input[])
    {
        Node root = new Node(input[0]);
        Stack<Node> st = new Stack<>();
        st.push(root);
         
         for(int idx=1;idx < input.length;idx++)
         {
             int val = input[idx];
             
             if(val == -1)
             {
                st.pop();
             }
             else
             {
                Node newnode = new Node(val);
                st.peek().children.add(newnode);
                st.push(newnode);
             }
         }
         
         return root;
        
    }
    
    public static void displayGenericTree(Node node)
    {
        System.out.print(node.data + " -> ");
        
        //print child nodes
        for(Node child:node.children)
        {
            System.out.print(child.data+" ");
        }
        System.out.println();
        
        for(Node child:node.children)
        {
            displayGenericTree(child);
        }
    }
    
    public static void main(String[] args)
    {
        int input[] = {10,20,50,-1,60,-1,-1,30,90,-1,-1,40,70,-1,80,-1,-1,-1};
        Node root = construct(input);
        displayGenericTree(root);
    }
}