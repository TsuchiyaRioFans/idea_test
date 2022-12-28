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

    public int closetTarget(String[] words, String target, int startIndex) {
        int ans = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<words.length;i++){
            if(words[i].equals(target)){
                list.add(i);
            }
        }
        for(int i=0;i<list.size();i++){
            int val = list.get(i);
            int dis1;
            int dis2;
            if(val>startIndex){
                dis1 = Math.abs(startIndex - val);
                dis2 = startIndex + (words.length - val);
            }
            else{
                dis1 = startIndex - val;
                dis2 = val + (words.length - startIndex);
            }
            ans = Math.min(ans,Math.min(dis1,dis2));
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    public static void main(String[] args) {
        Main main = new Main();
//        main.getNums("[[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]");
        int[] nums = new int[]{1,0,0,-1};
        String[] ss = new String[]{"a","b","leetcode"};
        int[][] nums1 = new int[][]{{-5,0}};
        main.closetTarget(ss,"leetcode",0);
    }
}
