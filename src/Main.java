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

    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m][n];
        int[] oneRows = new int[m];
        int[] oneCols = new int[n];
        for(int i=0;i<m;i++){
            int count = 0;
            for(int j=0;j<n;j++){
                if(grid[i][j]==1)
                    count++;
            }
            oneRows[i] = count;
        }
        for(int i=0;i<n;i++){
            int count = 0;
            for(int j=0;j<m;j++){
                if(grid[j][i]==1){
                    count++;
                }
            }
            oneCols[i]=count;
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans[i][j] = oneRows[i]+oneCols[j]-(m-oneRows[i])-(n-oneCols[j]);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Main main = new Main();
//        main.getNums("[[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]");
        int[] nums = new int[]{1000000000,1000000000,1000000000};
        String[] ss = new String[]{"gta","gta(1)","gta","avalon"};
        int[][] nums1 = new int[][]{{-5,0}};
    }
}
