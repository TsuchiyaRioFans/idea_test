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

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Set<String> set = new HashSet<>();
        Map<String,List<String>> map = new HashMap<>();
        for(int i=0;i<keyName.length;i++){
            if(set.contains(keyName[i]))
                continue;
            if(map.containsKey(keyName[i]))
                map.get(keyName[i]).add(keyTime[i]);
            else{
                List<String> list = new ArrayList<>();
                list.add(keyTime[i]);
                map.put(keyName[i],list);
            }
            Collections.sort(map.get(keyName[i]),(a,b)->{
                String[] ss1 = a.split(":");
                String[] ss2 = b.split(":");
                int a1 = Integer.parseInt(ss1[0]);
                int a2 = Integer.parseInt(ss1[1]);
                int b1 = Integer.parseInt(ss2[0]);
                int b2 = Integer.parseInt(ss2[1]);
                if(a1<b1)
                    return -1;
                if(a1>b1)
                    return 1;
                if(a2<b2)
                    return -1;
                if(a2>b2)
                    return 1;
                return 0;
            });
            List<String> temp = map.get(keyName[i]);
            for(int j=0;j<temp.size()-2;j++){
                if(fun(temp.get(j),temp.get(j+2))){
                    set.add(keyName[i]);
                    break;
                }
            }
        }
        List<String> ans = new ArrayList<>(set);
        Collections.sort(ans);
        return ans;
    }

    public boolean fun(String a,String b){
        String[] ss1 = a.split(":");
        String[] ss2 = b.split(":");
        int a1 = Integer.parseInt(ss1[0]);
        int a2 = Integer.parseInt(ss1[1]);
        int b1 = Integer.parseInt(ss2[0]);
        int b2 = Integer.parseInt(ss2[1]);
        int ans = 0;
        ans+=(b1-a1)*60;
        ans+=(b2-a2);
        return ans<=60;
    }
    public static void main(String[] args) {
        Main main = new Main();
//        main.getNums("[[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]");
        int[] nums = new int[]{1,1,1,1,1};
        String[] ss1 = new String[]{"daniel","daniel","daniel","luis","luis","luis","luis"};
        String[] ss2 = new String[]{"10:00","10:40","11:00","09:00","11:00","13:00","15:00"};
        int[][] nums1 = new int[][]{{0,1},{1,2},{3,1},{4,0},{0,5},{5,6}};
        main.alertNames(ss1,ss2);
    }
}
