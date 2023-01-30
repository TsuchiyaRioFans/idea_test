import netscape.javascript.JSUtil;

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
    public class TreeNode {
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


    public int distinctIntegers(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        List<Integer> temp =  new ArrayList<>();
        for(int i=0;i<(int)Math.pow(10,9);i++){
            for(Integer integer:set){
                for(int j=1;j<=integer;j++){
                    if(set.contains(j))
                        continue;
                    if(integer%j==1)
                        temp.add(j);
                }
            }
            if(temp.size()==0)
                break;
            set.addAll(temp);
            temp.clear();
        }
        return set.size();
    }

    public int monkeyMove(int n) {
        final int mod = (int)Math.pow(10,9)+7;
        long ans = 1;
        long val = 2;
        while(n>0){
            int flag = n&1;
            if(flag==1)
                ans *= val;
            val *= val;
            n >>= 1;
            if(ans>mod)
                ans %= mod;
            else if(ans<0)
                ans+=mod;
            if(val>mod)
                val%=mod;
            else if(val<0)
                val+=mod;
        }
        int res = (int)ans-2;
//        return res>=0?res:res+mod;
        return res;
    }

    public long putMarbles(int[] weights, int k) {
        List<Integer> list = new ArrayList<>();
        for(int n:weights)
            list.add(n);
        int n = weights.length;
        long max = weights[0]+weights[n-1];
        long min = weights[0]+weights[n-1];
        Collections.sort(list);
        return max-min;
    }


    class BIT {
        int[] tree;
        int n;

        public BIT(int n) {
            this.n = n;
            this.tree = new int[n + 1];
        }

        public int lowbit(int x) {
            return x & (-x);
        }

        public void update(int x, int d) {
            while (x <= n) {
                tree[x] += d;
                x += lowbit(x);
            }
        }

        public int query(int x) {
            int ans = 0;
            while (x != 0) {
                ans += tree[x];
                x -= lowbit(x);
            }
            return ans;
        }
    }

    public int trap(int[] height) {
        int n = height.length;
        int ans = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        for(int i=1;i<n;i++)
            left[i] = Math.max(left[i-1],height[i-1]);
        for(int i=n-2;i>=0;i--)
            right[i] = Math.max(right[i+1],height[i+1]);
        for(int i=0;i<n;i++){
            int bottom = height[i];
            int top = Math.min(left[i],right[i]);
            if(top<=bottom)
                continue;
            ans+=(top-bottom);
        }
        return ans;
    }


    public static void main(String[] args) {
        Main main = new Main();
//        main.getNums("[[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]");
        int[] nums = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int[][] nums1 = new int[][]{{0,1},{1,2},{3,1},{4,0},{0,5},{5,6}};
        main.trap(nums);
    }
}
