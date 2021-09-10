package Template;

import java.util.*;

public class ArraysSort {
    public static void main(String[] args) {
        int[][] properties = new int[100][2];
        int len = properties.length;
        if (len == 1) return;
        Arrays.sort(properties, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o2[1] - o1[1];
                return o1[0] - o2[0];
            }
        });
    }
}
