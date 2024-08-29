import java.util.Scanner;
import java.util.*;

public class Solution
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while(testCases>0){
			String pattern = in.nextLine();
            if(isValid(pattern)){
                System.out.println("Valid");
            }else{
                System.out.println("Invalid");
            }
            testCases--;
	}}
    public static boolean isValid(String s) {
        char a;
        

        Stack<Character> stack=new Stack<>();
        for (int i=0;i<s.length();i++){
            a=s.charAt(i);
            if(a=='(' || a=='{' || a=='['){
                stack.push(a);
            }
            else if(a==')' || a=='}' || a==']'){
                if((a==')' && stack.peek()=='(')|| (a==']' && stack.peek()=='[') ||(a=='}' && stack.peek()=='{')){
                stack.pop();
                }
                else{
                    return false;
                }
            }
        }
        if(stack.empty()){return true;} 
        return false;
        }


}

