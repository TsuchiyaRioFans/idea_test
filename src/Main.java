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

    boolean flag;
    public void dfs(List<Integer> list,String s,int pos){
        if(flag)
            return;
        if(pos==s.length()){
            if(list.size()>2)
                flag = true;
            return;
        }
        for(int i=pos+1;i<=s.length();i++){
            String temp = s.substring(pos,i);
            long val1 = Long.parseLong(temp);
            if(val1>Integer.MAX_VALUE)
                break;
            int val = Integer.parseInt(temp);
            if(temp.length()>=2&&temp.charAt(0)=='0')
                break;
            if(list.size()<=1){
                list.add(val);
                dfs(list,s,i);
            }
            else{
                int sum = list.get(list.size()-1)+list.get(list.size()-2);
                if(sum>val){
                    continue;
                }
                else if(sum==val){
                    list.add(sum);
                    dfs(list,s,i);
                }

                else
                    break;
            }
            if(flag)
                return;
            list.remove(list.size()-1);
        }
    }
    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> ans = new ArrayList<>();
        dfs(ans,num,0);
        return ans;
    }


    public static void main(String[] args) {
        Main main = new Main();
//        main.getNums("[[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]");
        int[] nums = new int[]{4,2,4,5,6};
        int[][] nums1 = new int[][]{{1,5},{1,1},{1,6},{0,2}};
        main.splitIntoFibonacci("5511816597");
    }
}
