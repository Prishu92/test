import java.util.*;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Test {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        List<String> lt= Arrays.asList("test","feb","hjk","zxzc");

        Collections.sort(lt);
        System.out.println(lt);

        String s="This is to remove duplicate";

        Set<Character> st=new HashSet<>();

        StringBuilder sb=new StringBuilder();

        for(int i=0;i<=s.length()-1;i++)
        {
            if(st.add(s.charAt(i)))
            {
                sb.append(s.charAt(i));
            }
        }
        System.out.println(sb);

        List<Integer> evodd=Arrays.asList(11,12,12,23,11,9,7,3);

        //Even Number and even Sum
        List<Integer> ev=evodd.stream().filter(e->e%2==0).collect(Collectors.toList());
        System.out.println(ev);

        int evsum=evodd.stream().filter(e->e%2==0).mapToInt(Integer::intValue).sum();
        System.out.println(evsum);

        //Odd Number and Odd Sum
        List<Integer> odd=evodd.stream().filter(e->e%2!=0).collect(Collectors.toList());
        System.out.println(odd);

        int oddsum=evodd.stream().filter(e->e%2!=0).mapToInt((Integer::intValue)).sum();
        System.out.println(oddsum);


        int i=10;
        int j=20;
        int temp;

        //temp=i;
        //i=j;
        //j=temp;
        //System.out.println(i +"and "+j);


        i=i+j;//30
        j=i-j;//10
        i=i-j;//20

        System.out.println(i+" and "+j);
        //fibonacci series
     int n1=0,n2=1,n3,n4=10;
        System.out.print(n1+""+n2);
     for(int i1=1;i1<n4;++i1)
     {
         n3=n1+n2;
         n1=n2;
         n2=n3;
         System.out.print(n3);
     }

      //swap the number
        int j1=10, k=30;

      j1=j1+k;
      k=j1-k;
      j1=j1-k;
        System.out.println(j1+" "+k);

        int p=13, m=0,flag=0;

        m=p/2;
        for(int c=2;c<=m;c++)
        {
            if(p%i==0)
            {
                System.out.println(p+ "This is not prime");
                flag=1;
                break;
            }


        }
        if(flag==0)
        {
            System.out.println(p+ "This is prime");
        }


    }
}