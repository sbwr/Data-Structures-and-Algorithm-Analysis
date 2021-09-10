package Contest.Contest60.S3;

import java.util.*;

class LockingTree {
    int[][] state;
    int[] parent;
    Deque<Integer> allChild = new ArrayDeque<>();

    public LockingTree(int[] parent) {
        /** state记录每个节点的状态， state[i][0]表示第i个节点的状态， state[i][1]表示对i上锁的user（未上锁为0） */
        state = new int[parent.length][2];
        this.parent = parent;
    }

    public boolean lock(int num, int user) {
        if (state[num][0] != 0)
            return false;
        else {
            state[num][0] = 1;
            state[num][1] = user;
            return true;
        }
    }

    public boolean unlock(int num, int user) {
        if (state[num][0] != 1 || state[num][1] != user)
            return false;
        else {
            state[num][0] = 0;
            return true;
        }
    }

    public boolean upgrade(int num, int user) {
        if (state[num][0] == 0 && checkUp(num) && checkDown(num)) {
            state[num][0] = 1;
            state[num][1] = user;
            unlockChild(num);
            return true;
        } else {
            //allChild.clear();
            return false;
        }
    }

    boolean checkUp(int num) {
        // 检查「祖先全部未上锁」
        int pr = parent[num];
        if (pr == -1)
            return true;
        if (state[pr][0] == 1)
            return false;
        return checkUp(pr);
    }

    boolean checkDown(int num) {
        // 检查「子孙有上锁」
        for (int i = 0; i < parent.length; i++) {
            int ch = parent[i];
            // 找到属于num的孩子
            if (ch == num) {
                if (state[i][0] == 1) { // 该子孙节点上锁
                    allChild.add(i); // 保存该
                    return true;
                }
                if (checkDown(i)) // 子孙的子孙有上锁
                    return true;
            }
        }
        return false;
    }

    void unlockChild(int num) {
        while (!allChild.isEmpty()) {
            int ch = allChild.poll();
            state[ch][0] = 0;
        }
    }
}

/**
 * Your LockingTree object will be instantiated and called as such: LockingTree
 * obj = new LockingTree(parent); boolean param_1 = obj.lock(num,user); boolean
 * param_2 = obj.unlock(num,user); boolean param_3 = obj.upgrade(num,user);
 */