import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class InterviewCode
{
    public static void main(String[] args) {
        Map<String, Integer> mp=new HashMap<String,Integer>();
        mp.put("hjhf",1);
        mp.put("yuuie",2);
        mp.put("zxcbm",3);
        mp.put("hkfdh",4);
        mp.put("ashaj",5);

        Map<String, Integer> mp1=new TreeMap<>();

        mp1.putAll(mp);

        System.out.println(mp1);

        String s="ssssjjjjjrrrrwwww";
        int count=1;
        StringBuilder sb =new StringBuilder();

        for(int i=1;i<=s.length();i++)
        {
            if(i<s.length()&&s.charAt(i)==s.charAt(i-1))
            {
                count++;
            }
            else
            {
                sb.append(s.charAt(i-1)).append(count);
                count=1;
            }
        }
        System.out.println(sb);
    }
}
