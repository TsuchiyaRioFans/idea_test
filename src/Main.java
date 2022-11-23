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
            ans = Math.max(ans,count);
            int val = nums[right];
            while (set.contains(val)){
                count-=nums[left];
                set.remove(nums[left]);
                left++;
            }
            count+=val;
            set.add(val);
            right++;
        }
        ans = Math.max(ans,count);
        return ans;
    }

    public int minimumSwap(String s1, String s2) {
        int xy = 0, yx = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == 'x' && s2.charAt(i) == 'y') {
                xy++;
            } else if (s1.charAt(i) == 'y' && s2.charAt(i) == 'x') {
                yx++;
            }
        }

        if (xy % 2 != yx % 2 ) {
            return -1;
        }
        return xy / 2 + yx / 2 + (xy % 2 == 1? 2: 0);
    }

    public int numOfSubarrays(int[] arr) {
        final int MODULO = 1000000007;
        int odd = 0, even = 1;
        int subarrays = 0;
        int sum = 0;
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            sum += arr[i];
            subarrays = (subarrays + (sum % 2 == 0 ? odd : even)) % MODULO;
            if (sum % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return subarrays;
    }
    public static void main(String[] args) {
        Main main = new Main();
//        main.getNums("[[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]");
        int[] nums = new int[]{4,2,4,5,6};
        int[][] nums1 = new int[][]{{1,5},{1,1},{1,6},{0,2}};
    }
}
