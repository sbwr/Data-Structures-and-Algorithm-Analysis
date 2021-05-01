# 232. 用栈实现队列
请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：

实现 MyQueue 类：

void push(int x) 将元素 x 推到队列的末尾
int pop() 从队列的开头移除并返回元素
int peek() 返回队列开头的元素
boolean empty() 如果队列为空，返回 true ；否则，返回 false
 
说明：

你只能使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 
进阶：

你能否实现每个操作均摊时间复杂度为 O(1) 的队列？换句话说，执行 n 个操作的总时间复杂度为 O(n) ，即使其中一个操作可能花费较长时间。
 
示例：

输入：
["MyQueue", "push", "push", "peek", "pop", "empty"]
[[], [1], [2], [], [], []]
输出：
[null, null, null, 1, 1, false]

解释：
MyQueue myQueue = new MyQueue();
myQueue.push(1); // queue is: [1]
myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
myQueue.peek(); // return 1
myQueue.pop(); // return 1, queue is [2]
myQueue.empty(); // return false
 
提示：

1 <= x <= 9
最多调用 100 次 push、pop、peek 和 empty
假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）

## 思路
考虑到栈和队列的唯一区别在于pop元素的位置：栈每次都在尾部输出元素，可以将栈内元素逆向存储。
[e1,e2,e3,e4] -> [e4,e3,e3,e1]
=======↑栈尾========↑栈尾
因此有两种方法实现：

1. 使用push() 插入元素时将栈两次翻转以得到调整后的栈，其他操作即可直接输出。其push() 时间复杂度为O(2n)，其他为O(1)。
2. push() 时直接插入元素到原始栈，pop() & peek() 查看元素时将栈翻转后输出。其push() 时间复杂度为O(1)，pop() & peek() 为O(n)。
在pop()操作次数>>peek()时 2 时间效率较高，在peek()操作较多时 1 时间效率更高.
选用方法1