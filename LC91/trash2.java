package LC91;

class trash2 {
    public int numDecodings(String s) {
        char[] c = s.toCharArray();
        int decodenum = 1, i = 0, j = 1, len = c.length;
        if(c[0] == '0') return 0;
        // 以两个数为单位处理
        for(; j < len; i++, j++){
            int num = -1;
            if(c[i]!=0 && c[j]!=0) num++;
            if(c[i]=='1') num++;
            else if(c[i]=='2' && c[j]>='0' && c[j]<='6') num++;
            if(num < 0) return 0;
            else decodenum += num;
        }
        return decodenum;
    }
}
