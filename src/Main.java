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


    class Pair{
        String in;
        String out;

        public Pair(String in, String out) {
            this.in = in;
            this.out = out;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return in.equals(pair.in) && out.equals(pair.out);
        }

        @Override
        public int hashCode() {
            return Objects.hash(in, out);
        }
    }


    class UndergroundSystem {

        Map<Integer,Integer> map;
        Map<Pair,List<Integer>> map1;
        Map<Integer,String> map2;
        public UndergroundSystem() {
            map = new HashMap<>();
            map1 = new HashMap<>();
            map2 = new HashMap<>();
        }

        public void checkIn(int id, String stationName, int t) {
            map.put(id,t);
            map2.put(id,stationName);
        }

        public void checkOut(int id, String stationName, int t) {
            int startTime = map.get(id);
            String startStation = map2.get(id);
            int time = t-startTime;
            Pair pair = new Pair(startStation,stationName);
            if(map1.containsKey(pair)){
                map1.get(pair).add(time);
            }
            else{
                List<Integer> list = new ArrayList<>();
                list.add(time);
                map1.put(pair,list);
            }
        }

        public double getAverageTime(String startStation, String endStation) {
            Pair pair = new Pair(startStation,endStation);
            if(!map1.containsKey(pair))
                return 0D;
            List<Integer> list = map1.get(pair);
            double ans = 0;
            for(int i=0;i<list.size();i++){
                ans+=list.get(i);
            }
            return ans/list.size();
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
//        main.getNums("[[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]");
        int[] nums = new int[]{0,1,-2,-3,4};
        int[][] nums1 = new int[][]{{1,5},{1,1},{1,6},{0,2}};
        System.out.println(1);
    }
}
