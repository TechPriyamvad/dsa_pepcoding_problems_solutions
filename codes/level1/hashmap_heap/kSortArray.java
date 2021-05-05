import java.io.*;
import java.util.*;

public class kSortedArray {

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int[] arr = new int[n];

      for (int i = 0; i < n; i++) {
         arr[i] = Integer.parseInt(br.readLine());
      }

      int k = Integer.parseInt(br.readLine());
      
      int res[] = kSortedArray(arr,k);
      
      for(int val:res)
      {
        System.out.println(val);
      }
   }
   
   public static int[] kSortedArray(int arr[],int k)
   {
       PriorityQueue<Integer> pq = new Priority<>();
       int res[] = new int[arr.length];
       
       int tmp = 0;
       for(int idx=0;idx < arr.length;idx++)
       {
           if(pq.size() < k+1)
           {
               pq.add(arr[idx]);
           }
           else
           {
               res[tmp] = pq.remove();
               pq.add(arr[idx]);
               tmp++;
           }
       }
       
       while(pq.size() > 0)
       {
           res[tmp] = pq.remove();
           tmp++;
       }
       
       return res;
   }

}