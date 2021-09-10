package LC68;

import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int len = words.length;
        int widthWithSpace = 0, width = 0; // width统计总字母数，widthwithspace记录含空格总长度
        int start = 0, end = 0;
        while (end < len) { // 字符序列未结束，则格式化一行
            widthWithSpace = 0;
            width = 0;
            start = end;
            // 能容纳的单词 words[start] ~ words[end-1]
            for (int i = start; i < len; i++) {
                int wlen = words[i].length();
                if (wlen <= maxWidth - widthWithSpace) {
                    width += wlen;
                    widthWithSpace += wlen;
                    end = i+1; // 记录该行最后一个单词words[end-1]
                    if (widthWithSpace == maxWidth) break;
                    widthWithSpace++; // 加一个空格
                } else break;
            }
            StringBuffer sb = new StringBuffer();
            if (end - start == 1) { // 仅一词
                sb.append(words[start]);
                for (int i = 0; i < maxWidth - width; i++) {
                    sb.append(' ');
                }
            }
            else if (end == len) { // 最后一行
                for (int i = start; i < end; i++) {
                    sb.append(words[i]);
                    if (i != end-1) sb.append(' ');
                }while (sb.length() < maxWidth) {
                    sb.append(' ');
                }
            }
            else { // 非最后一行
                // 算空格数
                int space = maxWidth - width, wnum = end - start;
                int[] sp = new int[wnum-1];
                for (int i = wnum-1; i >= 1; i--) {
                    sp[i-1] = space / i;
                    space -= sp[i-1];
                }
                for (int i = start; i < end; i++) {
                    sb.append(words[i]);
                    if (i == end-1) break;
                    for (int j = 0; j < sp[i-start]; j++) {
                        sb.append(' ');
                    }
                }
            } ans.add(sb.toString());
        }
        return ans;
    }
    public static void main(String[] args) {
        String[] words = {"What","must","be","acknowledgment","shall","be"};
        int maxWidth = 16;
        System.out.println(new Solution().fullJustify(words, maxWidth));
    }
}
