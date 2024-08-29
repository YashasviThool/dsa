import java.util.* ;
import java.io.*; 
public class Soulution {
    public static boolean ispossible(ArrayList<Integer> arr, int n, int m,int mid){
        
        int sum=0,studentCount=1;
        for(int i=0;i<n;i++){
        if(arr[i]+sum<=mid && studentCount<m){
            sum+=arr[i];
        }
        else{
            sum=arr[i];
            studentCount++;
        }
        if(arr[i]>mid){
            return false;
        }
        }
        return true;
    }

    public static int allocateBooks(ArrayList<Integer> arr, int n, int m) {
        // Write your code here.

        int s=0,e=0;
        int ans=-1;
        
        for(int i=0;i<n;i++){
            e+=arr[i];
        }
        int mid=(s+e)/2;
        
        while(s<=e){
        if(ispossible(arr,n,m,mid)){
            ans=mid;
            e=mid-1;
        }
        else{
            s=mid+1;
        }
        mid=(s+e)/2;
        }

    return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(12);
        arr.add(34);
        arr.add(67);

        for(int i=0;i<arr.size();i++){
            System.out.println(arr.get(i));
        }
    }
}
