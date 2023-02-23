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

    public String minRemoveToMakeValid(String s) {
        Stack<int[]> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='(')
                stack.push(new int[]{0,i});
            else if(ch==')'){
                if(!stack.isEmpty()&&stack.peek()[0]==0){
                    stack.pop();
                }
                else{
                    stack.push(new int[]{1,i});
                }
            }
        }
        List<int[]> list = new ArrayList<>();
        while (!stack.isEmpty()){
            list.add(stack.pop());
        }
        Collections.reverse(list);
        int pos = 0;
        for(int i=0;i<s.length();i++){
            if(pos<list.size()&&i==list.get(pos)[1]){
                pos++;
                continue;
            }
            char ch = s.charAt(i);
            sb.append(ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Main main = new Main();
//        main.getNums("[[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]");
        int[] nums = new int[]{8,11,17,2,25,29,21,20,4,22};
        int[][] nums1 = new int[][]{{1,1},{500000000,499999999},{1000000000,999999998}};
        int[][] nums2 = new int[][]{{1,3},{0,0},{0,3},{4,2},{1,0}};
    }
}
