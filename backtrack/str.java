package backtrack;

import java.util.Stack;

public class str {
    public static void main(String[] args) {
        String a="aldskfj";
        String b="y#f#ofa##sd";
        // System.out.println(trimer("", b));
        Stack<Character> stk=new Stack<>();
        // stk.push('a');
        char chr;
        for(int i=0;i<b.length();i++){
            chr=b.charAt(i);
            if(chr!='#'){
                stk.push(chr);

            }else{
                if(!stk.isEmpty()){
                    stk.pop();
                }
            }

        }
        System.out.println(stk.toString());
        boolean k=stk.equals(stk);
        System.out.println(k);
    }
    static String trimer(String p,String up){
        if(up.isEmpty()){
            return p;
        }
        char ch=up.charAt(0);
        if(ch!='#'){
            return trimer(p+ch, up.substring(1));
        }
        else if(p.length()>0){
            return trimer(p.substring(0, p.length()-1), up.substring(1));
        }
        return trimer(p, up.substring(1));

}}
