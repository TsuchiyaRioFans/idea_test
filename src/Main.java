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

    public double champagneTower(int poured, int query_row, int query_glass) {
        if(poured==0)
            return 0D;
        double[][] count = new double[query_row+1][query_row+1];
        count[0][0]=poured;
        int pos = 0;
        while (pos<=query_row){
            boolean flag = true;
            for(int i=0;i<=query_row;i++){
                if(count[pos][i]>1){
                    if(pos+1<=query_row){
                        double more = (count[pos][i]-1.0)/2.0;
                        count[pos][i]=1.0D;
                        count[pos+1][i]+=more;
                        count[pos+1][i+1]+=more;
                        flag = false;
                    }
                    else{
                        count[pos][i] = 1.0D;
                    }
                }
            }
            if(flag)
                break;
            pos++;
        }
        return count[query_row][query_glass];
    }

    public static void main(String[] args) {
        Main main = new Main();
//        main.getNums("[[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]");
        int[] nums = new int[]{3,0,2,5,4};
        int[][] nums1 = new int[][]{{1,5},{1,1},{1,6},{0,2}};
        main.champagneTower(100000009,33,17);

    }
}
