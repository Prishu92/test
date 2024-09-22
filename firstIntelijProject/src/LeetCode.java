import java.util.ArrayList;
import java.util.List;

public class LeetCode {
    public static void main(String args[])
    {
        System.out.println(lexicalOrder(13));
    }
      public static List<Integer> lexicalOrder(int n)
        {
            List<Integer> lt=new ArrayList<>();

            lexi(1,9,n,lt);
            return lt;
        }

        private static void lexi(int start, int end, int n, List<Integer> lt)
        {
            for(int i=start;i<=end && i<=n;i++)
            {
                lt.add(i);
                lexi(i*10,i*10+9,n,lt);
            }
        }
    }
