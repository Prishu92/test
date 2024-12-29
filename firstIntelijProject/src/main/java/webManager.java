import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class webManager {
    WebDriver driver=new ChromeDriver();
    @BeforeTest
    public void setup()
    {
        WebDriverManager.chromedriver().setup();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
    }

    @AfterTest
    public void quit()
    {
        driver.quit();
    }

    @Test
    public void practice(){
       String s="Remove duplicate";

       Set<Character> set=new HashSet<>();
       StringBuilder sb=new StringBuilder();

       for(int i=0;i<=s.length()-1;i++)
       {
           if(set.add(s.charAt(i)))
           {
               sb.append(s.charAt(i));
           }
       }
       System.out.println(sb);

       List<Integer> evvodd= Arrays.asList(1,23,21,34,45,43,22);

       List<Integer> evv=evvodd.stream().filter(e->e%2==0).collect(Collectors.toList());

       System.out.println(evv);

       List<Integer> odd=evvodd.stream().filter(e->e%2!=0).collect(Collectors.toList());
       System.out.println(odd);

       for(Integer j:evvodd)
        {
            if(j==0 || j==1)
            {
                System.out.println("This is not prime: " +j);
            }
            else if(j%2==0)
            {
                System.out.println("This is not prime: "+j);
            }
            else {
                System.out.println("This is prime: "+j);
            }
        }
    }
}
