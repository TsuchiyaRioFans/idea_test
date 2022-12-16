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

    public int minElements(int[] nums, int limit, int goal) {
        BigInteger sum = new BigInteger("0");
        for(int n:nums){
            sum = sum.add(new BigInteger(String.valueOf(n)));
        }
        BigInteger goal1 = new BigInteger(String.valueOf(goal));
        sum = goal1.subtract(sum);
        if(sum.signum()<0)
            sum = sum.multiply(new BigInteger("-1"));
        if(sum.signum()==0)
            return 0;
        int ans = 0;
        BigInteger temp = new BigInteger("0");
        BigInteger max = new BigInteger(String.valueOf(limit));
        temp = sum.divide(max);
        if(sum.mod(max).compareTo(new BigInteger("0"))>0){
            temp = temp.add(new BigInteger("1"));
        }
        return Integer.parseInt(String.valueOf(temp));
    }
    public static void main(String[] args) {
        Main main = new Main();
//        main.getNums("[[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]");
        int[] nums = new int[]{43024,99908};
        String[] ss = new String[]{"gta","gta(1)","gta","avalon"};
        int[][] nums1 = new int[][]{{1,2,4},{3,3,1}};
        System.out.println(Math.pow(10,14)>Long.MAX_VALUE);
    }
}
