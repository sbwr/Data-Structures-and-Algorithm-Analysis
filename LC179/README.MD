# 179. 最大数

给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。


示例 1：

输入：nums = [10,2]
输出："210"
示例 2：

输入：nums = [3,30,34,5,9]
输出："9534330"
示例 3：

输入：nums = [1]
输出："1"
示例 4：

输入：nums = [10]
输出："10"
 
提示：

1 <= nums.length <= 100
0 <= nums[i] <= 109

来自：力扣
https://leetcode-cn.com/problems/largest-number/

## 思路
越大的‘一位数字’放于越前，多位数仅看首位；
若有首位相同的多个数字，如[3, 30, 34]：下一位最大的放最前。

* 对于很多字符串的处理、排序，优先考虑Java集合类。compareto()恰好契合按位比较的需求

## 过程
1. nums[] -> ArrayList<String> numsAL[]
2. 使用Collection.sort()对numsAL排序
3. 将排序结果输出为一个字符串

## bugs
* return numsAL.toString(); // will get String[] by this mean
不能直接将ArrayList类型转换为单个字符串，应使用.get()方法逐个获取集合内容。

* bug: [0,0] -> 00    expected to be '0'
若输入中有且只有多个0，输出应为'0'，需要单独处理。

## 总结
* 极好的Collection, StringBuilder学习素材