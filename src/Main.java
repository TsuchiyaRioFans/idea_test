import java.util.*;

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

    public int expressiveWords(String s, String[] words) {
        int ans = 0;
        for (String word : words) {
            if (expand(s, word)) {
                ++ans;
            }
        }
        return ans;
    }

    private boolean expand(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) != t.charAt(j)) {
                return false;
            }
            char ch = s.charAt(i);
            int cnti = 0;
            while (i < s.length() && s.charAt(i) == ch) {
                ++cnti;
                ++i;
            }
            int cntj = 0;
            while (j < t.length() && t.charAt(j) == ch) {
                ++cntj;
                ++j;
            }
            if (cnti < cntj) {
                return false;
            }
            if (cnti > cntj && cnti < 3) {
                return false;
            }
        }
        return i == s.length() && j == t.length();
    }

    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] max = new int[26];
        for(String s:words2){
            int[] temp = new int[26];
            for(int i=0;i<s.length();i++){
                int pos = s.charAt(i)-'a';
                temp[pos]++;
            }
            for(int i=0;i<26;i++)
                max[i] = Math.max(max[i],temp[i]);
        }
        List<String> ans = new ArrayList<>();
        for(String s:words1){
            int[] temp = new int[26];
            for(int i=0;i<s.length();i++){
                int pos = s.charAt(i)-'a';
                temp[pos]++;
            }
            boolean flag = true;
            for(int i=0;i<26;i++){
                if(temp[i]<max[i]){
                    flag = false;
                    break;
                }
            }
            if(flag)
                ans.add(s);
        }
        return ans;
    }
    public static void main(String[] args) {
        Main main = new Main();
//        main.getNums("[[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]");
        int[] nums = new int[]{4,2,4,5,6};
        int[][] nums1 = new int[][]{{1,5},{1,1},{1,6},{0,2}};
    }
}
