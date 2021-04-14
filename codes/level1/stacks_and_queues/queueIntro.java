import java.util.Queue;
import java.util.ArrayDeque;

public class queueIntro
{
    public static void main(String args[])
    {
        Queue<Integer> qu = new ArrayDeque<>();
        System.out.println(qu);
        
        //insert elements into queue
        qu.add(10);
        System.out.println(qu);
        qu.add(20);
        qu.add(30);
        System.out.println(qu);
        
        //delete elements of queue from start
        System.out.println("remove->" + qu.remove());
        System.out.println(qu);
        
        //get first element of queue
        System.out.println("peek->" + qu.peek());
        
        //size of queue
        System.out.println("size->" + qu.size());
    }
}