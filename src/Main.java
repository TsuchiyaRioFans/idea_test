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

    public int videoStitching(int[][] clips, int time) {
        int[] dp = new int[time + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (int i = 1; i <= time; i++) {
            for (int[] clip : clips) {
                if (clip[0] < i && i <= clip[1]) {
                    dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
                }
            }
        }
        return dp[time] == Integer.MAX_VALUE - 1 ? -1 : dp[time];
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if((long)m*(long)k>n)
            return -1;
        int left = 0;
        int right = Arrays.stream(bloomDay).max().getAsInt();
        int mid;
        while (left<right){
            mid = left+(right-left)/2;
            boolean[] isVisited = new boolean[n];
            for(int i=0;i<n;i++){
                if(bloomDay[i]<=mid)
                    isVisited[i] = true;
            }
            int count = 0;
            int count1 = 0;
            int pos = 0;
            while (pos<n){
                if(isVisited[pos]){
                    count1++;
                    if(count1==k){
                        count++;
                        count1=0;
                    }
                }
                else{
                    count1 = 0;
                }
                pos++;
            }
            if(count>=m){
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = new int[]{0,0,0,0,0,0,0,0,0,0,1,2,3,4,5,6,7,8,9,10};
        int[][] nums1 = new int[][]{{0,1},{1,2}};
    }
}
