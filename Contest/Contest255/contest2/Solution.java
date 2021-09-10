package Contest.Contest255.contest2;

import java.util.BitSet;

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int m = (int)Math.pow(2,nums.length);
        BitSet bitset = new BitSet(m);//用于记录0-2^n-1上那些数已经存在nums中，


        for(String s : nums) {//将对应的数打上标志
            bitset.set(Integer.parseInt(s,2));
        }

        int res = 0;
        for(int i = 0; i < m; i++) {//在遍历一边，找到第一个没有打标志位的即可
            if(!bitset.get(i)) {
                res = i;
                break;
            }
        }

        StringBuilder sb = new StringBuilder(Integer.toBinaryString(res));

        if(sb.length() < nums.length) {//处理一下长度，保证得到的数是n位
            int size = sb.length();
            for(int i = 0; i < nums.length - size; i++) {
                sb.insert(0,0);
            }
        }

        return sb.toString();

    }

}