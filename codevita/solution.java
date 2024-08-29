import java.util.Arrays;

class solution {
    public int[] plusOne(int[] digits) {
        long sum=0;
        int len=digits.length;
        for(int i=0;i<len;i++){
            sum*=10;
            sum+=digits[i];

        }
        sum++;
        int []ans=new int[(int)Math.log10(sum)+1];
        for(int i=0;i<ans.length;i++){
            ans[ans.length - i-1]=(int)(sum%10);
            sum/=10;
        }
        return ans;
    }

    public static void main(String[] args) {
        int []arr={9,8,7,6,5,4,3,2,1,0};
        solution sol=new solution();
        int [] ans=sol.plusOne(arr);
        System.out.println(Arrays.toString(ans));
            
        
    }
}