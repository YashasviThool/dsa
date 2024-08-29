import java.util.*;

public class stack {
    
    public static int strStr(String haystack, String needle) {
        int ans=-1;
        int sizeOfNeedle = needle.length();
        String temp;
        for(int i=0;i<haystack.length()-sizeOfNeedle+1;i++){
            temp=haystack.length()>=sizeOfNeedle ? haystack.substring(i,i+sizeOfNeedle) : haystack;
            if(temp.equals(needle)){
                ans=i;
                break;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(strStr("null", "null"));
    }
}
