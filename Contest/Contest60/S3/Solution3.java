package Contest.Contest60.S3;

import java.util.*;

class LockingTree3 {
    public static class LockNode {
        int lockUser;
        int lockChild;
        List<Integer> child = new ArrayList<>();
    }

    LockNode[] nodes;
    int[] parent;

    public LockingTree3(int[] parent) {
        nodes = new LockNode[parent.length];
        for (int i = 0; i < parent.length; i++) {
            nodes[i] = new LockNode();
        }
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] != -1) {
                nodes[parent[i]].child.add(i);
            }
        }
        this.parent = parent;
    }

    public boolean lock(int num, int user) {
        if (nodes[num].lockUser == 0) {
            nodes[num].lockUser = user;
            while (parent[num] >= 0) {
                nodes[parent[num]].lockChild++;
                num = parent[num];
            }
            return true;
        }
        return false;
    }

    public boolean unlock(int num, int user) {
        if (nodes[num].lockUser == user) {
            nodes[num].lockUser = 0;
            while (parent[num] >= 0) {
                nodes[parent[num]].lockChild--;
                num = parent[num];
            }
            return true;
        }
        return false;
    }

    public boolean upgrade(int num, int user) {
        if (nodes[num].lockChild > 0 && nodes[num].lockUser == 0 && noLockParent(num)) {
            this.unlockAll(num);
            nodes[num].lockUser = user;
            return true;
        }
        return false;
    }

    private boolean noLockParent(int num) {
        while (parent[num] >= 0) {
            if (nodes[parent[num]].lockUser != 0) {
                return false;
            }
            num = parent[num];
        }
        return true;
    }

    private void unlockAll(int num) {
        nodes[num].lockUser = 0;
        if (nodes[num].lockChild == 0) {
            return;
        }
        nodes[num].lockChild = 0;
        for (int c : nodes[num].child) {
            unlockAll(c);
        }
    }

}