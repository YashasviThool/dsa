import java.util.Scanner;
public class prob2 {
public static void main(String[] args) 
{
    Scanner sc = new Scanner(System.in);
    String ashok = sc.nextLine();
    String anand = sc.nextLine();
    char ashok_char[] = ashok.toCharArray();
    char anand_char[] = anand.toCharArray();
    int ashok_comb=comb(ashok_char,ashok_char.length);
    int anand_comb=comb(anand_char,anand_char.length);
    if(ashok_comb==0 && anand_comb==0)
        System.out.print("Invalid it is");
    if(ashok_comb>anand_comb)
        System.out.print("Ashok");
    else if(anand_comb > ashok_comb)
        System.out.print("Anand");
    else 
        System.out.print("Draw");
}

static int comb(char arr[],int n)
{
    int ans=0;
    String temp="";
    for(int i=0;i<n;i++)
    {
        temp=""+arr[i];
        for(int j=i+1;j<n;j++)
        {
            temp+=arr[j];
            if(temp.charAt(0)!=arr[j])
            {
                for(int k=j+1;k<n;k++)
                {
                    if(temp.charAt(1)!=arr[k])
                      ans++;
                }
            }
            temp=""+arr[i];
        }
    }
    return ans;
}
}

