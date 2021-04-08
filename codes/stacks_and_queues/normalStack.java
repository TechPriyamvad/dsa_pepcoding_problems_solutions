import java.io.*;
import java.util.*;

public class normalStack {

  public static class CustomStack {
    int[] data;
    int tos;

    public CustomStack(int cap) {
      data = new int[cap];
      tos = -1;
    }

    int size() {
      return tos + 1;
    }

    void display() {
      for(int idx=tos;idx >= 0;idx--)
      {
          System.out.print(data[idx]+" ");
      }
      System.out.println();
    }

    void push(int val) {
        if(size() == data.length)
        {
            System.out.println("Stack overflow");
            return;
        }
      tos++;
      data[tos] = val;
    }

    int pop() {
        if(size() == 0)
        {
            System.out.println("Stack underflow");
            return -1;
        }
        else
        {
            int val = data[tos];
            data[tos] = 0;
            tos--;
            return val;
        }
      
    }

    int top() {
       if(size() == 0)
        {
            System.out.println("Stack underflow");
            return -1;
        }
        else
        {
            int val = data[tos];
            //data[tos] = 0;
            return val;
        }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    CustomStack st = new CustomStack(n);

    String str = br.readLine();
    while(str.equals("quit") == false){
      if(str.startsWith("push")){
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push(val);
      } else if(str.startsWith("pop")){
        int val = st.pop();
        if(val != -1){
          System.out.println(val);
        }
      } else if(str.startsWith("top")){
        int val = st.top();
        if(val != -1){
          System.out.println(val);
        }
      } else if(str.startsWith("size")){
        System.out.println(st.size());
      } else if(str.startsWith("display")){
        st.display();
      }
      str = br.readLine();
    }
  }
}