package tests;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntegerManupulation {

    public Object[][] data() {
        return new Object[][]{
                {"2,3,4,12,13,15,19"},
                {"1,2,3,4,5,6,7,89,9"}
        };
    }

    @Test(priority = 1, enabled = true)
    public void findMax() {
        int[] val = {2, 3, 4, 12, 13, 19, 15, 21, 2, 29};
        for (int i = 0; i < val.length; i++) {
            for (int j = i + 1; j < val.length; j++) {
                if (val[i] > val[j]) {
                    int temp = val[i];
                    val[i] = val[j];
                    val[j] = temp;
                }
            }
        }
        System.out.println("Max value is: " + val[val.length - 1]);
    }

    @Test(priority = 2, enabled = true)
        public void findMin() {
        int [] val={-1,2,-3,2,5,4,6,7,45,6};
        for(int i=0;i<val.length;i++){
            for(int j=i+1;j<val.length;j++){
                if(val[i]>val[j]){
                    int temp=val[i];
                    val[i]=val[j];
                    val[j]=temp;
                }
            }
        }
        System.out.println("Minmum value is: " + val[0]);
    }
    @Test(priority = 3, enabled = true)
    public void binaryGap(){
        int n = 11111111;
       String s=Integer.toString(n);
       int max=0;
       int count=0;
       for(int i=0;i<s.length();i++) {
           char ch = s.charAt(i);
           if (ch == '0') {
               count++;
               if (count > max) {
                   max = count;
               }
           } else {
               count = 0;
           }
       }
       System.out.println("Binary Gap is: " + max);
    }

    //Array Shift
    @Test(priority = 4, enabled = true)
    public void arrShift(){
         int[]arr={1,2,3,4,5,6,7,8};
         int k=3;
         int n=arr.length;
         k=k%n;
         int[] shifted=new int[n];
         for(int i=0;i<n;i++){
             shifted[(i+k)%n]=arr[i];
         }
         System.out.println("Shifted array: "+Arrays.toString(shifted));
    }
    //Find Odd Occurence
    @Test(priority = 5, enabled = true)
    public void findOddOccurrence(){
        int[]arr={9, 3, 9, 3, 9, 7, 9};
        int odd=0;
        for(int arr1:arr){
            odd ^=arr1;
        }
        System.out.println("Odd Occurrence is: " + odd);
    }
}
