import jdk.nashorn.internal.runtime.regexp.JoniRegExp;
import netscape.javascript.JSUtil;

import java.math.BigDecimal;
import java.math.BigInteger;
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

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    static public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }


    public int lastStoneWeightII(int[] ss) {
        int n = ss.length;
        int sum = 0;
        for (int i : ss) sum += i;
        int t = sum / 2;
        int[][] f = new int[n + 1][t + 1];
        for (int i = 1; i <= n; i++) {
            int x = ss[i - 1];
            for (int j = 0; j <= t; j++) {
                f[i][j] = f[i - 1][j];
                if (j >= x)
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - x] + x);
            }
        }
        return Math.abs(sum - f[n][t] - f[n][t]);
    }


    public int longestStrChain(String[] words) {
        Map<String,Integer> map = new HashMap<>();
        Arrays.sort(words,(a,b)->a.length()-b.length());
        int ans = 0;
        for(String s:words){
            map.put(s,1);
            for(int i=0;i<s.length();i++){
                String prev = s.substring(0,i)+s.substring(i+1);
                if(map.containsKey(prev)){
                    int max = Math.max(map.get(s),1+map.get(prev));
                    map.put(s,max);
                }
            }
            ans = Math.max(ans,map.get(s));
        }
        return ans;
    }

    public int minOperations(int[] nums) {
        int n = nums.length, gcdAll = 0, cnt1 = 0;
        for (int x : nums) {
            gcdAll = gcd(gcdAll, x);
            if (x == 1)
                ++cnt1;
        }
        if (gcdAll > 1)
            return -1;
        if (cnt1 > 0)
            return n - cnt1;

        int minSize = n;
        for (int i = 0; i < n; ++i) {
            int g = 0;
            for (int j = i; j < n; ++j) {
                g = gcd(g, nums[j]);
                if (g == 1) {
                    // 这里本来是 j-i+1，把 +1 提出来合并到 return 中
                    minSize = Math.min(minSize, j - i);
                    break;
                }
            }
        }
        return minSize + n - 1;
    }

    private int gcd(int a, int b) {
        while (a != 0) {
            int tmp = a;
            a = b % a;
            b = tmp;
        }
        return b;
    }

    public int fun1(int[] nums){
        int ans = 0;
        while (true){
            boolean flag = true;
            for(int i=1;i<3;i++){
                if(nums[i]-nums[i-1]!=1){
                    flag = false;
                    break;
                }
            }
            if(flag)
                break;
            int dis1 = nums[1]-nums[0];
            int dis2 = nums[2]-nums[1];
            ans++;
            if(dis1==1||dis2==1){
                break;
            }
            if(dis1>=dis2){
                nums[0]=nums[1];
                nums[1] = nums[0]+1;
            }
            else{
                nums[2] = nums[1];
                nums[1] = nums[2]-1;
            }
        }
        return ans;
    }

    public int fun2(int[] nums){
        int ans = nums[1]-nums[0]+nums[2]-nums[1]-2;
        return ans;
    }
    public int[] numMovesStones(int a, int b, int c) {
        int[] ans = new int[2];
        int[] temp1 = new int[]{a,b,c};
        Arrays.sort(temp1);
        int[] temp2 = Arrays.copyOf(temp1,3);
        ans[0] = fun1(temp1);
        ans[1] = fun2(temp2);
        return ans;
    }
    public static void main(String[] args) {
        Main main = new Main();
//        main.getNums("[[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]");
        int[] nums = new int[]{0,0};
        main.numMovesStones(1,3,2);
    }
}
