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

    public boolean isCircularSentence(String sentence) {
        String[] ss = sentence.split(" ");
        for(int i=0;i<ss.length;i++){
            int after = (i+1)%ss.length;
            String s1 = ss[i];
            String s2 = ss[after];
            if(s1.charAt(s1.length()-1)!=s2.charAt(0))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Main main = new Main();
//        main.getNums("[[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]");
        int[] nums = new int[]{9,1,2,3,9};
        int[][] nums1 = new int[][]{{1,5},{1,1},{1,6},{0,2}};

    }
}
