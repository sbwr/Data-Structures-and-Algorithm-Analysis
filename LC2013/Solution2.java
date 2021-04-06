package LC2013;

class Solution2 {
    public int trap(int[] height) {
        int len = height.length;
        // int[] trap = new int[len];
        int trap = trap(height, 0, len);
        return trap;
    }
    // water trap in [a,b]
    // Overloading method
    private static int trap(int[] height, int a, int b){
        int[] max = {0, 0}, max_index = {a, a};
        
        if(b - a <= 1) return 0;// head meeting rear means over
        for(int i = a; i < b; i++){
            // keep max num in max[0], second max num in max[1]
            // max[] can be optimized(replaced)
            // max num's index in max_index;
            if(height[i] >= max[0]){
                max[1] = max[0]; max_index[1] = max_index[0];
                max[0] = height[i]; max_index[0] = i;
            }
            else if(height[i] >= max[1]){
                max[1] = height[i];
                max_index[1] = i;
            }
        }

        // determine new [a,b] as computational interval
        if(max_index[0] - max_index[1] < 1 && max_index[0] - max_index[1] > -1) {
            return 0;
        } 
        if(max_index[0] < max_index[1]) {
            a = max_index[0]; 
            b = max_index[1];
        }
        else {
            b = max_index[0]; 
            a = max_index[1];
        }
        // a = max_index[0] > max_index[1] ? max_index[0] : max_index[1];
        // b = max_index[0] < max_index[1] ? max_index[0] : max_index[1];

        // calculate the sum within [a,b]
        int sum = 0;
        for(int i = a + 1; i < b; i++){
            sum += max[1] - height[i];
        }
        return sum + trap(height, 0, a) + trap(height, b, height.length-1);
    }
    public static void main(String arg[]){
        int[] height = {0,1,0,2,1,0,1};
        Solution2 s = new Solution2();
        System.out.println(s.trap(height));
    }
}