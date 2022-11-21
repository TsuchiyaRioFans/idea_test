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

    public int unequalTriplets(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i]!=nums[j]){
                    for(int k=j+1;k<n;k++){
                        if(nums[j]!=nums[k]&&nums[i]!=nums[k])
                            ans++;
                    }
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Main main = new Main();
//        main.getNums("[[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]");
        int[] nums = new int[]{3,0,2,5,4};
        int[][] nums1 = new int[][]{{1,5},{1,1},{1,6},{0,2}};
    }
}
