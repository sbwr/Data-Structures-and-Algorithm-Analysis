package LC91;

class trash {
    public int numDecodings(String s) {
        char[] c = s.toCharArray();
        if(c[0] == '0') return 0;
        int i = 0, len = s.length(), sum = 1, j = 1;
        for(; i < len; i++, j++){
            if(c[i] == 0) continue;
            else {
                // sum ++;
                if(i < len-1) {
                    if(c[i] == '1') sum++;
                    else if(c[i] == '2' && c[j] >= '0' && c[j] <= '6') 
                        sum++;
                }
            }
        }
        return sum;
    }
    
}