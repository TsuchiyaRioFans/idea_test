import java.util.*;

public class Main {

    public void getNums(String s){
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='[')
                sb.append('{');
            else if(ch==']')
                sb.append('}');
            else
                sb.append(ch);
        }
        System.out.println(sb.toString());
    }

    public int maximumUniqueSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        int count = 0;
        while (right<nums.length){
            int val = nums[right];
            if(set.contains(val)){
                ans = Math.max(ans,count);
                while (set.contains(val)){
                    count-=nums[left];
                    set.remove(nums[left]);
                    left++;
                }
            }
            count+=val;
            set.add(val);
            right++;
        }
        ans = Math.max(ans,count);
        return ans;
    }
    public static void main(String[] args) {
        Main main = new Main();
//        main.getNums("[[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]");
        int[] nums = new int[]{4,2,4,5,6};
        int[][] nums1 = new int[][]{{1,5},{1,1},{1,6},{0,2}};
        main.maximumUniqueSubarray(nums);
    }
}
