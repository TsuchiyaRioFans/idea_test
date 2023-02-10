import jdk.nashorn.internal.runtime.regexp.JoniRegExp;
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


    public long pickGifts(int[] gifts, int k) {
        long ans = 0;
        Queue<Integer> queue = new PriorityQueue<>((a,b)->b.compareTo(a));
        for(int n:gifts){
            queue.offer(n);
        }
        for(int i=0;i<k;i++){
            int top = queue.poll();
            int temp = (int)Math.sqrt(top);
            queue.offer(temp);
        }
        while (!queue.isEmpty()){
            ans+=queue.poll();
        }
        return ans;
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = queries.length;
        int[] ans = new int[n];
        int[] counts = new int[words.length+1];
        Set<Character> set = new HashSet<>();
        set.add('a');set.add('e');set.add('i');set.add('o');set.add('u');
        for(int i=1;i<=words.length;i++){
            String s = words[i-1];
            if(set.contains(s.charAt(0))&&set.contains(s.charAt(s.length()-1))){
                counts[i] = 1+counts[i-1];
            }
            else{
                counts[i] = counts[i-1];
            }
        }
        for(int i=0;i<n;i++){
            int left = queries[i][0];
            int right = queries[i][1];
            ans[i]=(counts[right+1]-counts[left]);
        }
//        words = ["aba","bcb","ece","aa","e"], queries = [[0,2],[1,4],[1,1]]
//        [0,1,1,2,3,4]
        return ans;
    }



    public int minCapability(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[k+1][n+1];
        for(int i=2;i<=k;i++)
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        for(int i=1;i<=n;i++)
            dp[1][i] = nums[i-1];
        for(int i=2;i<=k;i++){
            for(int j=i+1;j<=n;j++){
                for(int t=j-2;t>=1;t--){
                    dp[i][j] = Math.min(dp[i][j],Math.max(nums[t-1],dp[i-1][t]));
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            if(dp[k][i]==0)
                continue;
            ans = Math.min(ans,dp[k][i]);
        }
        return ans;
    }

    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int n = nums[i];
            List<Integer> temp = new ArrayList<>();
            while (n!=0){
                int val = n%10;
                n/=10;
                temp.add(val);
            }
            Collections.reverse(temp);
            list.addAll(temp);
        }
        int[] ans = new int[list.size()];
        for(int i=0;i<list.size();i++)
            ans[i] = list.get(i);
        return ans;
    }

    public int maxPoints(int[][] points) {
        Map<String,Set<Integer>> map = new HashMap<>();
        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                int fenzi = points[j][1]-points[i][1];
                int fenmu = points[j][0]-points[i][0];
                String temp = null;
                if(fenmu==0){
                    temp = "!"+String.valueOf(points[i][0]);
                }
                else{
                   double k = (double) fenzi/ (double) fenmu;
                   double b = points[i][1]-k*points[i][0];
                   temp = String.valueOf(k)+"-"+String.valueOf(b);
                }
                if(map.containsKey(temp)){
                    map.get(temp).add(i);
                    map.get(temp).add(j);
                }
                else{
                    Set<Integer> set = new HashSet<>();
                    set.add(i);
                    set.add(j);
                    map.put(temp,set);
                }
            }
        }
        int ans = 1;
        for(String key:map.keySet()){
            ans = Math.max(ans,map.get(key).size());
        }
        return ans;
    }

    public int calculate(String s) {
        Deque<Integer> ops = new LinkedList<Integer>();
        ops.push(1);
        int sign = 1;
        int ret = 0;
        int n = s.length();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                sign = ops.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -ops.peek();
                i++;
            } else if (s.charAt(i) == '(') {
                ops.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                ops.pop();
                i++;
            } else {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                ret += sign * num;
            }
        }
        return ret;
    }

    public int bestClosingTime(String customers) {
        int n = customers.length();
        int[] left = new int[n+1];
        for(int i=1;i<=n;i++){
            if(customers.charAt(i-1)=='Y'){
                left[i] = 1+left[i-1];
            }
            else
                left[i] = left[i-1];
        }
        int ans = 0;
        int max = Integer.MAX_VALUE;
        for(int i=0;i<=n;i++){
            int val1 = i-left[i];
            int val2 = (left[n]-left[i]);
            if(max>val1+val2){
                max = val1+val2;
                ans = i;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Main main = new Main();
//        main.getNums("[[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]");
        int[] nums = new int[]{2,3,5,9};
        int[][] nums1 = new int[][]{{0,0},{4,5},{7,8},{8,9},{5,6},{3,4},{1,1}};
        int[][] nums2 = new int[][]{{1,3},{0,0},{0,3},{4,2},{1,0}};
        main.bestClosingTime("YYNY");
    }
}
