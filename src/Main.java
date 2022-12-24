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

    public String largestMerge(String word1, String word2) {
        StringBuffer sb = new StringBuffer();
        int pos1 = 0;
        int pos2 = 0;
        while(pos1<word1.length()&&pos2<word2.length()){
            char ch1 = word1.charAt(pos1);
            char ch2 = word2.charAt(pos2);
            if(ch1>ch2){
                sb.append(ch1);
                pos1++;
            }
            else if(ch1<ch2){
                sb.append(ch2);
                pos2++;
            }
            else{
                int temp1 = pos1+1;
                int temp2 = pos2+1;
                boolean flag = true;
                while (temp1<word1.length()&&temp2<word2.length()){
                    if(word1.charAt(temp1)==word2.charAt(temp2)){
                        temp1++;
                        temp2++;
                    }
                    else if(word1.charAt(temp1)>word2.charAt(temp2))
                        break;
                    else{
                        flag = false;
                        break;
                    }
                }
                if(flag&&temp1!=word1.length()){
                    sb.append(ch1);
                    pos1++;
                }
                else{
                    sb.append(ch2);
                    pos2++;
                }
            }
        }
        while (pos1<word1.length()){
            char ch1 = word1.charAt(pos1);
            sb.append(ch1);
            pos1++;
        }
        while (pos2<word2.length()){
            char ch2 = word2.charAt(pos2);
            sb.append(ch2);
            pos2++;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Main main = new Main();
//        main.getNums("[[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]");
        int[] nums = new int[]{1000000000,1000000000,1000000000};
        String[] ss = new String[]{"gta","gta(1)","gta","avalon"};
        int[][] nums1 = new int[][]{{-5,0}};
    }
}
