## 第四题 字符串相等

### 问题描述
比较两字符串a和b，如果长度为奇数则要求完全相同；
如果长度为偶数则可将其等分为两子串a1,a2和b1,b2；如果满足a1=b2 && a2=b1也视为相等；若仍为偶数字符串则仍可再分

### 输入
* 样例：
8
aaaaaaaabbbbbbbb
bbbbbbbbaaaaaaaa
ababababaaabababababab
ababababababababababaa
aaabbb
bbbaaa
cba
abc
aaba
abaa
aabb
abab
aaabbb
bbbaaa
cba
abc
* 解释：
第一行为 需要比较的字符串的组数；
其他每两行为 一组比较对象。
* 输入限制：
2+行输入为小写字母串，每组内一样长。