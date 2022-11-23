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

    static class SnapshotArray {
        int count;
        Map<Integer,Map<Integer,Integer>> map;

        int[] nums;
        List<Integer> change;
        public SnapshotArray(int length) {
            map = new HashMap<>();
            for(int i=0;i<length;i++){
                map.put(i,new HashMap<>());
            }
            this.count = 0;
            nums = new int[length];
            change = new ArrayList<>();
        }

        public void set(int index, int val) {
            nums[index] = val;
            change.add(index);
        }

        public int snap() {
            for(int i=0;i<change.size();i++){
                int pos = change.get(i);
                map.get(pos).put(count,nums[pos]);
            }
            count++;
            change.clear();
            return count-1;
        }

        public int get(int index, int snap_id) {
            Map<Integer,Integer> tempMap = map.get(index);
            int temp = snap_id;
            while (temp>=0){
                if(tempMap.containsKey(temp)){
                    return tempMap.get(temp);
                }
                temp--;
            }
            return 0;
        }
    }
    public static void main(String[] args) {
        Main main = new Main();
//        main.getNums("[[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]");
        int[] nums = new int[]{4,2,4,5,6};
        int[][] nums1 = new int[][]{{1,5},{1,1},{1,6},{0,2}};
        SnapshotArray snapshotArray = new SnapshotArray(3);
        snapshotArray.set(0,4);
        snapshotArray.set(0,16);
        snapshotArray.set(0,13);
        snapshotArray.snap();
        snapshotArray.get(0,0);
        snapshotArray.snap();
    }
}
