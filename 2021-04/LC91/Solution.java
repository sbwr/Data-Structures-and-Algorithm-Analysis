package LC91;

class Solution {
    public int numDecodings(String s) {
        // char[] c = s.toCharArray(); // 使用额外空间，避免频繁使用charAt
        int i = 0, len = s.length();
        int[] record = new int[3]; // 循环记录[i-2, i]处累计的解码方式数量
        // 单独处理i=0，i=1；此处冗长复杂，待优化
        if(s.charAt(i) == '0') return 0;
        else {
            record[0] = 1;
            i++;
        }
        if(len == 1) return 1;
        if(s.charAt(i) != '0') record[1] += record[0];
        if(s.charAt(i-1) == '1' || s.charAt(i-1) == '2' && s.charAt(i) >= '0' && s.charAt(i) <= '6'){ // 可组成两位码
            record[1] ++;
        }
        i++;
        for(; i < len; i++){
            record[i%3] = 0;
            if(s.charAt(i) != '0') record[i%3] += record[(i-1)%3];
            if(s.charAt(i-1) == '1' || s.charAt(i-1) == '2' && s.charAt(i) >= '0' && s.charAt(i) <= '6'){ // 可组成两位码
                record[i%3] += record[(i-2)%3];
            }
        }
        return record[(len-1)%3];
    }
}
