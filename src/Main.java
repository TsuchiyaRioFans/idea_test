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

    public boolean canChoose(int[][] groups, int[] nums) {
        int pos = 0;
        for(int[] group:groups){
            boolean flag1 = false;
            while (pos<nums.length){
                if(nums[pos]==group[0]){
                    boolean flag = true;
                    int temp = pos+1;
                    int pos1 = 1;
                    while (temp<nums.length&&pos1<group.length){
                        if(nums[temp]!=group[pos1]){
                            flag = false;
                            break;
                        }
                        temp++;
                        pos1++;
                    }
                    if(flag&&pos1==group.length){
                        flag1 = true;
                        pos = temp;
                        break;
                    }
                    else{
                        pos++;
                    }
                }
                else{
                    pos++;
                }
            }
            if(!flag1)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Main main = new Main();
//        main.getNums("[[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]");
        int[] nums = new int[]{1,-1,0,1,-1,-1,3,-2,0};
        String[] ss = new String[]{"gta","gta(1)","gta","avalon"};
        int[][] nums1 = new int[][]{{-5,0}};
        main.canChoose(nums1,nums);
    }
}
