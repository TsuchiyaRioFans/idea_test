import java.util.*;

import static java.lang.Character.toLowerCase;

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

    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] cnt = new int[n + 1];
        int odd = 0, ans = 0;
        cnt[0] = 1;
        for (int i = 0; i < n; ++i) {
            odd += nums[i] & 1;
            ans += odd >= k ? cnt[odd - k] : 0;
            cnt[odd] += 1;
        }
        return ans;
    }

    public Map<Long,Integer> getSums(int[] nums1){
        int m = nums1.length;
        Map<Long,Integer> map = new HashMap<>();
        for(int i=0;i<m;i++){
            for(int j=i+1;j<m;j++){
                long val = (long)nums1[i]*(long)nums1[j];
                map.put(val,1+map.getOrDefault(val,0));
            }
        }
        return map;
    }

    public int getAns(Map<Long,Integer> sum,int[] nums){
        int ans = 0;
        for(int n:nums){
            long temp = (long)Math.pow(n,2);
            ans+=sum.getOrDefault(temp,0);
        }
        return ans;
    }
    public int numTriplets(int[] nums1, int[] nums2) {
        Map<Long,Integer> sum1 = getSums(nums1);
        Map<Long,Integer> sum2 = getSums(nums2);
        return getAns(sum1,nums2)+getAns(sum2,nums1);
    }

    public int numSteps(String s) {
        if(s.length()==1){
            return s.equals("0")?1:0;
        }
        StringBuffer sb = new StringBuffer(s);
        int ans = 0;
        while (sb.length()>1){
            int length = sb.length();
            if(sb.charAt(length-1)=='0'){
                sb.deleteCharAt(length-1);
            }
            else{
                sb.setCharAt(length-1,'0');
                boolean flag = false;
                for(int i=length-2;i>=0;i--){
                    char ch = sb.charAt(i);
                    if(ch=='0'){
                        sb.setCharAt(i,'1');
                        flag = true;
                        break;
                    }
                    else{
                        sb.setCharAt(i,'0');
                    }
                }
                if(!flag)
                    sb.insert(0,'1');
            }
            ans++;
        }
        return sb.toString().equals("1")?ans:ans+1;
    }
    public static void main(String[] args) {
        Main main = new Main();
//        main.getNums("[[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]");
        int[] nums = new int[]{43024,99908};
        int[][] nums1 = new int[][]{{1,5},{1,1},{1,6},{0,2}};
        main.numSteps("1101");
    }
}
