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


    public int maxValue(int n, int index, int maxSum) {
        int left = 1;
        int right = maxSum;
        while (left<right){
            int mid = left+(right-left)/2;
            if(isValid(index,mid,maxSum,n)){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        if(isValid(index,left,maxSum,n))
            return left;
        return left-1;
    }

    public boolean isValid(int index,int val,int max,int n){
        long count = 0;
        if(val>index){
            count+= (long) (val + val - index) *(1+index)/2;
        }
        else{
            count+=((index-val+1)+ (long) (1 + val) *(val)/2);
        }
        if(count>max)
            return false;
        if(val>=(n-index)){
            count+= (long) (val + val - (n - index)+1) *(n-index)/2;
        }
        else{
            count+=(n-index-val)+ (long) (1 + val) *(val)/2;
        }
        count-=val;
        return count<=max;
    }
    public static void main(String[] args) {
        Main main = new Main();
//        main.getNums("[[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]");
        int[] nums = new int[]{1,0,0,-1};
        String[] ss = new String[]{"a","b","leetcode"};
        int[][] nums1 = new int[][]{{-5,0}};
        main.maxValue(4,2,6);
    }
}
