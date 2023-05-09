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

    public String fractionAddition(String expression) {
        int n = expression.length();
        char[] chs = expression.toCharArray();
        String ans = "";
        for(int i=0;i<n;){
            int j =i+1;
            while (j<n&&chs[j]!='-'&&chs[j]!='+')
                j++;
            String t = expression.substring(i,j);
            if(chs[i]!='+'&&chs[i]!='-')
                t = "+"+t;
            ans = ans.equals("")?t:calc(ans,t);
            i=j;
        }
        return ans.charAt(0)=='+'?ans.substring(1):ans;
    }

    public String calc(String a,String b){
        boolean fa = a.charAt(0)=='+';
        boolean fb = b.charAt(0)=='+';
        if(!fa&&fb)
            return calc(b,a);
        long[] p = parse(a);
        long[] q = parse(b);
        long p1 =p[0]*q[1];
        long p2 = p[1]*q[0];
        if(fa&&fb){
            long r1 = p1+p2, r2 = p[1]*q[1] , c = gcd(r1,r2);
            return "+"+(r1/c)+"/"+(r2/c);
        }
        else if(!fa){
            long r1 = p1+p2, r2 = p[1]*q[1] , c = gcd(r1,r2);
            return "-"+(r1/c)+"/"+(r2/c);
        }
        else{
            long r1 = p1 - p2, r2 = p[1] * q[1], c = gcd(Math.abs(r1), r2);
            String ans = (r1 / c) + "/" + (r2 / c);
            return p1 >= p2 ? "+" + ans : ans;
        }

    }

    public long gcd(long a,long b){
        if(a<b){
            return gcd(b,a);
        }
        return b == 0?a:gcd(b,a%b);
    }

    public long[] parse(String s){
        int n = s.length();
        long[] ans = new long[2];
        int pos = 1;
        while (pos<n){
            char ch = s.charAt(pos);
            if(ch=='/')
                break;
            pos++;
        }
        ans[0] = Long.parseLong(s.substring(1,pos));
        ans[1] = Long.parseLong(s.substring(pos+1));
        return ans;
    }
    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = new int[]{0,0,0,0,0,0,0,0,0,0,1,2,3,4,5,6,7,8,9,10};
        int[][] nums1 = new int[][]{{0,1},{1,2}};
        System.out.println(1);
    }
}
