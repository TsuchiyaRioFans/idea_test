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


    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Set<Integer> set = new HashSet<>();
        set.add(0);
        Map<Integer,List<Integer>> map = new HashMap<>();
        Set<Integer> unUse = new HashSet<>();
        for(int val:restricted)
            unUse.add(val);
        for(int[] nums:edges) {
            int left = nums[0];
            int right = nums[1];
            if (!unUse.contains(left) && !unUse.contains(right)) {
                if (map.containsKey(left))
                    map.get(left).add(right);
                else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(right);
                    map.put(left, temp);
                }
                if (map.containsKey(right))
                    map.get(right).add(left);
                else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(left);
                    map.put(right, temp);
                }
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()){
            int length = queue.size();
            for(int i=0;i<length;i++){
                int val = queue.poll();
                if(map.containsKey(val)){
                    List<Integer> temp = map.get(val);
                    for(int j=0;j<temp.size();j++){
                        int t = temp.get(j);
                        if(set.contains(t))
                            continue;
                        set.add(t);
                        queue.offer(t);
                    }
                }
            }
        }
        return set.size();
    }
    public static void main(String[] args) {
        Main main = new Main();
//        main.getNums("[[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]");
        int[] nums = new int[]{4,5};
        String[] ss = new String[]{"a","b","leetcode"};
        int[][] nums1 = new int[][]{{0,1},{1,2},{3,1},{4,0},{0,5},{5,6}};
        main.reachableNodes(7,nums1,nums);
    }
}
