import java.util.ArrayList;

import javax.print.DocFlavor.STRING;

public class permutaiton {
    public static void main(String[] args) {
        // int a=Permutaiton("", "abc");
        // System.out.println("\n"+a);
        ArrayList<String> a=Perm("", "abcdefghij");
        System.out.println(a);
        System.out.println(a.size());

    }

    static int Permutaiton(String p, String up) {
        if (up.isEmpty()) {
            System.out.print(p + " ");
            return 1;
        }
        int count = 0;
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String first = p.substring(0, i);
            String second = p.substring(i, p.length());
            count += Permutaiton(first + ch + second, up.substring(1));
        }
        return count;
    }

    static ArrayList<String> Perm(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list=new ArrayList<String>();
            list.add(p);
            return list;

        }
        ArrayList<String> ans=new ArrayList<String>();
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String first = p.substring(0, i);
            String second = p.substring(i, p.length());
            ans.addAll(Perm(first + ch + second, up.substring(1)));
        }
        return ans;
    }
}
