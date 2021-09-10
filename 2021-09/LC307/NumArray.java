package LC307;

class NumArray {
    int[] tree;
    int n;
    // 初始化
    public NumArray(int[] nums) {
        n = nums.length;
        tree = new int[n * 2];
        // 构造线段树数组
        for(int i = n; i < 2*n; i++){
            tree[i]  = nums[i-n];
        }
        for(int i = n-1; i >= 0; i--){
            tree[i] = tree[i*2] + tree[i*2+1];
        }
    }
    
    public void update(int i, int val) {
        int pos = n + i;
        tree[pos] = val;
        while(pos > 0){
            int left = pos%2==0? pos: pos-1;
            int right = pos%2==0? pos+1: pos;
            tree[pos/2] = tree[left] + tree[right];
            pos /= 2;
        }
    }
    
    public int sumRange(int i, int j) {
        int sum = 0;
        int l = n + i;
        int r = n + j;
        while(r >= l){
            // 仅当l为奇数或r为偶数时 -- (即l为右孩子，r~左时)加上该结点数值，否则向上寻找父结点。
            if(l % 2 == 1){
                sum += tree[l];
                l++;
            }
            if(r % 2 == 0){
                sum += tree[r];
                r--;
            }
            l /= 2;
            r /= 2;
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        NumArray N = new NumArray(nums);
        N.sumRange(0, 2);
        N.update(1, 2);
        N.sumRange(0, 2);
    }
}