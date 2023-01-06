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

    public int[] rearrangeBarcodes(int[] barcodes) {
        int n = barcodes.length;
        int[] ans = new int[n];
        Map<Integer,Integer> map = new HashMap<>();
        for(int m:barcodes){
            map.put(m,1+map.getOrDefault(m,0));
        }
        Queue<Map.Entry<Integer,Integer>> queue = new
                PriorityQueue<>((a,b)->b.getValue().compareTo(a.getValue()));
        for(Map.Entry<Integer,Integer> entry:map.entrySet())
            queue.offer(entry);
        int pos = 0;
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>();
        while (!queue.isEmpty()){
            Map.Entry<Integer,Integer> entry = queue.poll();
            int key = entry.getKey();
            int value = entry.getValue();
            if(pos==0||ans[pos-1]!=key){
                ans[pos] = key;
                if(value>1){
                    entry.setValue(value-1);
                    queue.offer(entry);
                }
            }
            else{
                list.add(entry);
                while (!queue.isEmpty()){
                    Map.Entry<Integer,Integer> temp = queue.poll();
                    if(temp.getKey()!=ans[pos-1]){
                        ans[pos] = temp.getKey();
                        if(temp.getValue()>1){
                            temp.setValue(temp.getValue()-1);
                            list.add(temp);
                        }
                        break;
                    }
                    list.add(temp);
                }
                for(int i=0;i<list.size();i++)
                    queue.offer(list.get(i));
                list.clear();
            }
            pos++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Main main = new Main();
//        main.getNums("[[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]");
        int[] nums = new int[]{2,2,1,3};
        String[] ss = new String[]{"a","b","leetcode"};
        int[][] nums1 = new int[][]{{-5,0}};
        main.rearrangeBarcodes(nums);
    }
}
