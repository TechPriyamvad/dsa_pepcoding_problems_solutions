import java.io.*;
import java.util.*;

public class STOCKSPAN{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + "\n");
    }
    System.out.println(sb);
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    int[] span = solve(a);
    display(span);
 }

 public static int[] solve(int[] arr){
   
   int n = arr.length;
   Stack<Integer> st = new Stack<>();
   
   //storing inbnext greater elements
   int ngel[] = new int[n];
   
   ngel[0] = -1;
   st.push(0);
   
   //storing data in ngel array
   for(int idx=1;idx < n;idx++)
   {
       //when elements to the left are smaller and stack is not full
       //pop those elements 
       while(st.size() > 0 && arr[idx] > arr[st.peek()])
       {
           st.pop();
       }
       
       //if stack is full store -1 in ngel array
       //if stack is not full store value at top of stack
       ngel[idx] = st.size()==0 ? -1 : st.peek();
       
       //push indexes to stack
       st.push(idx);
   }
   
   //span array to store span
   int span[] = new int[n];
   for(int idx=0;idx < n;idx++)
   {
       span[idx] = idx - ngel[idx];
   }
   
   return span;
 }

}