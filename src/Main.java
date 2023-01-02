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

    public int getNumberOfBacklogOrders(int[][] orders) {
        int ans = 0;
        Queue<int[]> buy = new PriorityQueue<>((a,b)->b[0]-a[0]);
        Queue<int[]> sell = new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int[] order:orders){
            int type = order[2];
            int val = order[0];
            int count = order[1];
            if(type==0){
                while (!sell.isEmpty()&&sell.peek()[0]<=val&&count>0){
                    int count1 = sell.peek()[1];
                    if(count>=count1){
                        count-=count1;
                        sell.poll();
                    }
                    else{
                        sell.peek()[1]-=count;
                        count = 0;
                    }
                }
                if(count>0)
                    buy.offer(new int[]{val,count});
            }
            else{
                while (!buy.isEmpty()&&buy.peek()[0]>=val&&count>0){
                    int count1 = buy.peek()[1];
                    if(count>=count1){
                        count-=count1;
                        buy.poll();
                    }
                    else{
                        buy.peek()[1]-=count;
                        count = 0;
                    }
                }
                if(count>0)
                    sell.offer(new int[]{val,count});
            }
        }
        final int mod = (int)Math.pow(10,9)+7;
        while (!buy.isEmpty()){
            int[] temp = buy.poll();
            ans+=temp[1];
            ans%=mod;
        }
        while (!sell.isEmpty()){
            int[] temp = sell.poll();
            ans+=temp[1];
            ans%=mod;
        }
        return ans;
    }

    public static void main(String[] args) {
        Main main = new Main();
//        main.getNums("[[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]");
        int[] nums = new int[]{1,0,0,-1};
        String[] ss = new String[]{"a","b","leetcode"};
        int[][] nums1 = new int[][]{{-5,0}};
    }
}
