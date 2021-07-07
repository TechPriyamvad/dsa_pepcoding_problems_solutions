



import java.util.*;
import java.io.*;
class Node{
    int data;
    ArrayList<Node> children = new ArrayList<>();
    Node(int data){
        System.out.println("Node created");
        this.data = data;
    }
}
class GT{
    Node root; 
    GT(Integer inp[]){
        System.out.println("Constructing your generic Tree");
        root = construct(inp);
    }
    private static class Pair{
        Node node;
        int state;
        Pair(Node node,int state){
            this.state = state;
            this.node = node;
        }
    }
    private Node construct(Integer inp[]){
      Node root = new Node(inp[0]);
      Stack<Node> st = new Stack<>();
      st.push(root);
      for(int idx=1;idx < inp.length;idx++)
      {
          int val = inp[idx];
          if(val==-1)
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
    public void display(){
        display(root);
    }
    public int size(){
        return size(root);
    }
    public int sum(){
        return sum(root);
    }
    public int max(){
        return max(root);
    }
    public int min(){
        return min(root);
    }
    public int height(){
        return height(root);
    }
    public boolean find(int data){
        return find(root,data);
    }
    public ArrayList<Integer> nodeToRootPath(int data){
        return nodeToRootPath(root,data);
    }
    private void display(Node node) {
        System.out.print(node.data + " -> ");
        for(Node child:node.children)
        {
            System.out.print(" "+child.data+",");
        }
        System.out.println(" .");
        for(Node child:node.children)
        {
            display(child);
        }
    }

    private int size(Node node) {
        
        int res = 0;
        for(Node child:node.children)
        {
            res += size(child);
        }
        res += 1;
        return res;
    }
  
    private int sum(Node node) {
        if(node==null)
        {
            return 0;
        }
        
        int res = 0;
        for(Node child:node.children)
        {
            res += sum(child);
        }
        
        res += node.data;
        return res;
    }
  
    private int max(Node node) {
        
        if(node==null)
        {
            return Integer.MIN_VALUE;
        }
        
        int res = 0;
        for(Node child:node.children)
        {
            int data = max(child);
            if( data > res)
            {
                res = data;
            }
        }
        
        if(node.data > res)
        {
            res = node.data;
        }
        
        return res;
        
    }
    private int min(Node node) {
        if(node==null)
        {
            return Integer.MAX_VALUE;
        }
        
        int res = 0;
        for(Node child:node.children)
        {
            int data = min(child);
            if( data > res)
            {
                res = data;
            }
        }
        
        if(node.data < res)
        {
            res = node.data;
        }
        
        return res;
    }
    
    private int height(Node node) {
        return 1;
    }

    private boolean find(Node node, int data){
        return true;
    }
    
    private ArrayList<Integer> nodeToRootPath(Node node, int data){
        ArrayList<Integer> list = new ArrayList<>();
        return list;
    }

}

public class Solution{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            if (values[i].equals("n") == false) {
                arr[i] = Integer.parseInt(values[i]);
            } else {
                arr[i] = null;
            }
        }
        int data = Integer.parseInt(br.readLine());
        GT gt = new GT(arr);

        gt.display();
        System.out.println("Size " + gt.size());
        System.out.println("Sum "+gt.sum());
        System.out.println("Max "+gt.max());
        System.out.println("Min "+gt.min());
        System.out.println("Height "+gt.height());

        boolean found = gt.find(data);
        System.out.println(found);

        ArrayList<Integer> path = gt.nodeToRootPath(data);
        System.out.println(path);
    }
}