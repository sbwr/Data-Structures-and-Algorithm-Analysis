package LC403;

import java.util.*;
// 超出内存限制
public class Solution {
    public boolean canCross(int[] s) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<Integer> getlist;
        for (int i : s) {
            ArrayList<Integer> putlist = new ArrayList<>();
            putlist.add(0);
            map.put(i, putlist);
        }
        if(map.get(1) == null) return false;
        getlist = map.get(1);
        getlist.add(1);
        map.put(1, getlist);
        for (int i = 1; i < s.length; i++){
            getlist = map.get(s[i]);
            for (Integer k : getlist) {
                if(k == 0) continue;
                if(k>1 && map.get(s[i]+k-1) != null) {
                    getlist = map.get(s[i]+k-1);
                    getlist.add(k-1);
                }
                if(map.get(s[i]+k) != null) {
                    getlist = map.get(s[i]+k);
                    getlist.add(k);
                }
                if(map.get(s[i]+k+1) != null) {
                    getlist = map.get(s[i]+k+1);
                    getlist.add(k+1);
                }
            }
        }
        ArrayList<Integer> zerolist = new ArrayList<>();
        zerolist.add(0);
        if(map.get(s[s.length-1]).size() == 1)return false;
        return true;
    }
    public static void main(String[] args) {
        int[] nums = {0,2};
        Solution s = new Solution();
        System.out.println(s.canCross(nums));
        
    }
}
