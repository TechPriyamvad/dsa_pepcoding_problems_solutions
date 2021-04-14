import java.io.*;
import java.util.*;

public class nextGreaterElementToTheRight{
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

    int[] nge = solve(a);
    display(nge);
 }

 public static int[] solve(int[] arr){
   // solve
   int n = arr.length;
   int[] narr = new int[n];
   Stack<Integer> st = new Stack<>();
 
   //as there is no element greater to rigth of last elemnent so
   //we will put -1 at last of new array
   narr[n-1] = -1;
   st.push(arr[n-1]);
   
   for(int idx = n-2;idx >=0;idx--)
   {
       while(st.size() > 0 && arr[idx] > st.peek())
       {
           st.pop();
       }
       
       narr[idx] = st.size() == 0 ? -1 : st.peek();
       st.push(arr[idx]);
       
   }
   return narr;
 }

}