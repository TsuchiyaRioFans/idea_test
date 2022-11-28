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

    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        double[][] dp = new double[n+1][k+1];
        double[] sum = new double[n+1];
        for(int i=1;i<=n;i++){
            sum[i] = sum[i-1]+nums[i-1];
        }
        for(int i=1;i<=n;i++)
            dp[i][1] = sum[i]/i;
        for(int j=2;j<=k;j++){
            for(int i=j;i<=n;i++){
                for(int p=j-1;p<i;p++){
                    double val = dp[p][j-1]+(sum[i]-sum[p])/ (i-p);
                    dp[i][j] = Math.max(dp[i][j],val);
                }
            }
        }
        return dp[n][k];
    }

    public static void main(String[] args) {
        Main main = new Main();
//        main.getNums("[[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]");
        int[] nums = new int[]{9,1,2,3,9};
        int[][] nums1 = new int[][]{{1,5},{1,1},{1,6},{0,2}};
        main.largestSumOfAverages(nums,3);
    }
}
