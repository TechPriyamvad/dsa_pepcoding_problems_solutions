import java.util.*;
import java.io.*;
class Node{
    int data;
    Node left , right;
    Node(int data){
        System.out.println("Node created");
        this.data = data;
    }

    Node(int data , Node left , Node right){
        this(data);
        this.left = left;
        this.right = right;
    }
}
class BT{
    Node root; 
    BT(Integer inp[]){
        System.out.println("Constructing your binary Tree");
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
      // code for contructing binary tree
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
        // code for displaying binary tree
    }

    private int size(Node node) {
        // code for finding size of binary tree
    }
  
    private int sum(Node node) {
        // code for finding sum of binary tree
    }
  
    private int max(Node node) {
        // code for finding max of binary tree
    }
    private int min(Node node) {
        // code for finding min of binary tree
    }
    
    private int height(Node node) {
        // code for finding height of binary tree
    }

    private boolean find(Node node, int data){
        // code for finding data in a binary tree
    }
    
    private ArrayList<Integer> nodeToRootPath(Node node, int data){
        // code for nodeToRootPath in a binary tree
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
        BT bt = new BT(arr);

        bt.display();
        System.out.println("Size " + bt.size());
        System.out.println("Sum "+bt.sum());
        System.out.println("Max "+bt.max());
        System.out.println("Min "+bt.min());
        System.out.println("Height "+bt.height());

        boolean found = bt.find(data);
        System.out.println(found);

        ArrayList<Integer> path = bt.nodeToRootPath(data);
        System.out.println(path);
    }
}