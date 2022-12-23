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
    public ListNode removeNodes(ListNode head) {
        Deque<ListNode> deque = new ArrayDeque<>();
        while (head!=null){
            if(deque.isEmpty())
                deque.offerLast(head);
            else{
                while (!deque.isEmpty()){
                    int val = deque.peekLast().val;
                    if(val<head.val){
                        deque.pollLast();
                    }
                    else
                        break;
                }
                if(!deque.isEmpty()){
                    deque.peekLast().next = head;
                }
                deque.offerLast(head);
            }
            head = head.next;
        }
        return deque.peekFirst();
    }
    public static void main(String[] args) {
        Main main = new Main();
//        main.getNums("[[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]");
        int[] nums = new int[]{1000000000,1000000000,1000000000};
        String[] ss = new String[]{"gta","gta(1)","gta","avalon"};
        int[][] nums1 = new int[][]{{-5,0}};
    }
}
