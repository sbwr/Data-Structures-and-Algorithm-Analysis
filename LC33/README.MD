# 33. 搜索旋转排序数组
整数数组 nums 按升序排列，数组中的值 互不相同 。

在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array

## 思路
使用二分法搜索，由中间将数组划分为两部分(start, mid) & (mid, end)，则必有至少一部分为有序的，由此可以判断target若存在，应在哪一部分。

* 由于数组的索引为整数，需特别注意无法整除时start, mid, end的情况，例如nums = {1, 2}时
* Related Problem: 81. 搜索旋转排序数组 II