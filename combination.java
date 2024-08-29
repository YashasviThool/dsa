import java.util.ArrayList;
import java.util.List;

public class combination {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        combi(ans,new ArrayList<>(),candidates,target,0);
        return ans;
    }
    
    public void combi(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{ 
        
            for(int i = start; i < nums.length; i++){
                tempList.add(nums[i]);
                combi(list, tempList, nums, remain - nums[i], i);
                tempList.remove(tempList.size() - 1);
        }
    }
    }

    public static void main(String[] args) {
        combination c = new combination();
        System.out.println(c.combinationSum(new int[] { 2, 3, 6, 7 }, 7));
    }
}
