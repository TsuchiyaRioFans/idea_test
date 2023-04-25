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

    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        boolean[] visited = new boolean[n];
        Arrays.sort(nums);
        int count = 0;
        while (true){
            Set<Integer> set = new HashSet<>();
            for(int i=0;i<n;i++){
                if(visited[i])
                    continue;
                if(set.contains(nums[i]))
                    continue;
                set.add(nums[i]);
                visited[i] = true;
            }
            count+=set.size();
            ans.add(new ArrayList<>(set));
            if(count==n)
                break;
        }
        return ans;
    }

    public long[] findPrefixScore(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];
        int max = nums[0];
        ans[0] = 2L *nums[0];
        for(int i=1;i<n;i++){
            max = Math.max(max,nums[i]);
            ans[i] = nums[i]+max;
        }
        return ans;
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


    public String solveEquation(String s) {
        int x = 0,num = 0;
        int n = s.length();
        for(int i=0,op=1;i<n;){
            char ch = s.charAt(i);
            if(ch=='+'){
                op=1;i++;
            }
            else if(ch=='-'){
                op=-1;i++;
            }
            else if(ch=='='){
                op=1;x*=-1;num*=-1;i++;
            }
            else{
                int j =i;
                while (j<n){
                    char ch1 = s.charAt(j);
                    if(ch1=='+'||ch1=='-'||ch1=='=')
                        break;
                    j++;
                }
                if(s.charAt(j-1)=='x'){
                    x+= op*(i<j-1?(Integer.parseInt(s.substring(i,j-1))):1);
                }
                else{
                    num+=op*Integer.parseInt(s.substring(i,j));
                }
                i=j;
            }
        }
        if(x==0)
            return num==0?"Infinite solutions":"No solution";
        return "x="+(num/-x);
    }

    public int sumOfMultiples(int n) {
        int ans = 0;
        for(int i=1;i<=n;i++){
            if(i%3==0||i%5==0||i%7==0){
                ans+=i;
            }
        }
        return ans;
    }

    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<k;i++)
            list.add(nums[i]);
        Collections.sort(list);
        int left = 0;
        int right = k;
        for(int i=0;i<ans.length;i++){
            int val = list.get(x-1);
            if(val<0)
                ans[i] = val;
            if(right<n){
                int pos1 = Collections.binarySearch(list,nums[left]);
                list.remove(pos1);
                int pos2 = Collections.binarySearch(list,nums[right]);
                if(pos2<0)
                    pos2 = -1*pos2 -1;
                list.add(pos2,nums[right]);
                left++;
                right++;
            }
        }
        return ans;
    }

    public static int gcd(int a, int b) {
        return b != 0 ? gcd(b, a%b) : a;
    }
    public int minOperations(int[] nums) {
        boolean flag = false;
        int n = nums.length;
        for(int i=0;i<n-1;i++){
            int val1 = nums[i];
            int val2 = nums[i+1];
            if(val1%2==0&&val2%2==1)
                flag = true;
            if(val1%2==1&&val2%2==0)
                flag = true;
        }
        if(!flag)
            return -1;
        return n;
    }


    public int[] supplyWagon(int[] supplies) {
        int n = supplies.length;
        List<Integer> list = new ArrayList<>();
        for(int m:supplies)
            list.add(m);
        while (true){
            int min = list.get(0)+list.get(1);
            int pos = 0;
            for(int i=1;i<list.size()-1;i++){
                int val = list.get(i)+list.get(i+1);
                if(val<min){
                    min = val;
                    pos = i;
                }
            }
            int sum = list.get(pos)+list.get(pos+1);
            list.remove(pos);
            list.remove(pos);
            list.add(pos,sum);
            if(list.size()<=n/2)
                break;
        }
        int[] ans = new int[n/2];
        for(int i=0;i<list.size();i++)
            ans[i] = list.get(i);
        return ans;

    }

    public static void main(String[] args) {
        Main main = new Main();
//        main.getNums("[[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]");
        int[] nums = new int[]{410193,229980,600441};
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++)
                System.out.println(gcd(nums[i],nums[j]));
        }

    }
}
