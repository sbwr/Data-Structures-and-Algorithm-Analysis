# 42 接雨水（与面试题 17.21.“直方图的水量” 重复）
给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。

上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。 感谢 Marcos 贡献此图。

示例:

输入: [0,1,0,2,1,0,1,3,2,1,2,1]
输出: 6

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/volume-of-histogram-lcci

1. Solution1 passed
* Process
    search for right max and left max for every grid

    use the minimum of 2 max nums to minus the depth of every grid
    to get water traped in width 1

    add all grids' results up

* Complexity
    traverse every grid twice, also traverse in searching max nums
    O(n^2)

2. Solution2 failed
* Process
    traverse every level(height = 0 -> max) of the map until no "wall"(black blocks)

    start to count water blanks when meeting the first wall, end when meeting the last
    (how to set the end condition??)

    add total blanks of all levels up

* Complexity
    maxheight * lengthn
    O(n) when n >> height

3. Solution3(improved version of Solution2)
* Process
    count the sum grid covered by wall and water:
        use two pointers named left & right to search left and right border for each layer

    water = sum - wall

* Complexity
    O(n)

4. Solution4  dynamic planning
* Process
    traverse and save leftmax and rightmax of every grid respectively

    traverse every grid using:
        water += Math.min(leftmax, rightmax) - height[this grid]

* Complexity
    O(n)