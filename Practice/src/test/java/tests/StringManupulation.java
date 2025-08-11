package tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class StringManupulation{
    @DataProvider(name = "stringDataProvider")
    public Object[][] stringDataProvider() {
        return new Object[][] {
                {"madam"},
                {"racecar"},
                {"hello"}
        };
    }
    @Test(priority = 1, enabled = false, dataProvider = "stringDataProvider")
    public void reverseString(String str){
        String rvrs="";
        for(int i=str.length()-1;i>=0;i--){
            rvrs += str.charAt(i);
        }
        System.out.println("Reversed String: " + rvrs);

        char[] ch=str.toCharArray();
        int left=0, right=ch.length-1;
        while(left<right){
            char temp=ch[left];
            ch[left]=ch[right];
            ch[right]=temp;
            left++;
            right--;
        }
        System.out.println(ch);

    }

    @Test(priority = 2, enabled = false, dataProvider = "stringDataProvider")
    public void countVowels(String str){
      //  String str = "Prashant Singh";
        int count =0;
        for(int i=0; str.length()>i;i++){
            char ch = str.charAt(i);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch =='u' ||ch=='A'
            || ch =='E' || ch=='I' || ch=='O' || ch =='U'){
                count++;
            }
        }
        System.out.println("Number of vowels in the string: " + count);
    }
    @Test(priority = 3, enabled = false, dataProvider = "stringDataProvider")
    public void displayDuplicateCharacters(String str){
       // String str = "Prashant Singh";
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            for(int j=i+1;j<str.length();j++){
                if(ch == str.charAt(j)){
                    System.out.println("Duplicate character: " + ch);
                    break; // To avoid printing the same character multiple times
                }
            }
        }
    }

    @Test(priority = 4, enabled = true, dataProvider = "stringDataProvider")
    public void palindromeCheck(String str){
        str=str.replaceAll("a-zA-Z0-9","").toLowerCase();
        System.out.println(str.equals(new StringBuilder(str).reverse().toString()));
    }

    @Test(priority =5, enabled =false)
    public void numInString() {
        String str = "Pras234hant123";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch)) {
                System.out.println("Number in the string: " + ch);
            }
        }
    }
    @Test(priority = 6, enabled = false)
    public void findValidEmail() {
        String email = "testtest.com";
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        if (email.matches(emailRegex)) {
            System.out.println("Valid email: " + email);
        } else {
            System.out.println("Invalid email: " + email);
        }
    }

    @Test(priority = 7, enabled = true)
    public void api(){
         Response response= given().
                 when().
                 get("https://reqres.in/api/users/2").
                 then()
                 .statusCode(200)
                 .extract().response();
         System.out.println(response.asString());
         String email=response.jsonPath().getString("data.email");
         Assert.assertEquals(email,"janet.weaver@reqres.in");
         Assert.assertEquals(response.jsonPath().getString("support.text"),"Tired of writing endless social media content? Let Content Caddy generate it for you.");
     }
}