package Contest.Contest60.S3;

import java.util.*;

class LockingTree2 { //让每个节点维护一个「子孙节点表」存放节点i的所有子孙
    List<List<Integer>> c;
    int[][] state;
    int[] parent;
    boolean lockedChild = false; // true - 有上锁的子孙

    public LockingTree2(int[] parent) {
        /** state记录每个节点的状态， state[i][0]表示第i个节点的状态， state[i][1]表示对i上锁的user（未上锁为0） */
        state = new int[parent.length][2];
        this.parent = parent;
        // 建立子孙节点表c
        c = new ArrayList<>();
        for (int i = 0; i < parent.length; i++) {
            c.add(new ArrayList<>());
        }
        for (int i = 0; i < parent.length; i++) {
            if (c.get(i).isEmpty())
                findChild(i); 
        }
    }
    void findChild(int num) {
        // 找到num的子孙
        for (int i = 0; i < parent.length; i++) {
            int ch = parent[i];
            // 找到属于num的孩子
            if (ch == num) {
                c.get(num).add(i);
                findChild(i);
                c.get(num).addAll(c.get(i));
            }
        }
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
        // 检查「子孙有上锁」并解锁所有已上锁子孙
        List<Integer> list = c.get(num);
        lockedChild = false;
        for (Integer i : list) {
            if (state[i][0] == 1) {
                lockedChild = true;
                state[i][0] = 0;
            }
        }
        return lockedChild;
    }

}

/**
 * Your LockingTree object will be instantiated and called as such: LockingTree
 * obj = new LockingTree(parent); boolean param_1 = obj.lock(num,user); boolean
 * param_2 = obj.unlock(num,user); boolean param_3 = obj.upgrade(num,user);
 */