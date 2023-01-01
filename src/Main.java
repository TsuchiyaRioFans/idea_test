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

    int n;

    public int maxDistance(int[] price, int k) {
        this.n = price.length;
        Arrays.sort(price);
        int left = 0;
        int right = price[n-1];
        while (left+1<right){
            int mid = left+(right-left)/2;
            if(check(price,mid,k)){
                left = mid;
            }
            else{
                right = mid;
            }
        }
        return left;
    }
    public boolean check(int[] price,int val,int k){
        int pre = price[0];
        int count = 1;
        for(int i=1;i<n;i++){
            if(pre+val<=price[i]){
                count++;
                pre = price[i];
            }
            if(count==k)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Main main = new Main();
//        main.getNums("[[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]");
        int[] nums = new int[]{1,0,0,-1};
        String[] ss = new String[]{"a","b","leetcode"};
        int[][] nums1 = new int[][]{{-5,0}};
    }
}
