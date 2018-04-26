// My solution： 
class Solution {
    
    public int sum = 0;
    
    public int pathSum(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>(); // store start index of each level
        for(int i = 0; i < nums.length; i++) {
            int level = nums[i] / 100;
            if(!map.containsKey(level)) map.put(level, i);
        }
        dfs(nums, nums[0], 2, nums[0] % 10, map);
        return sum;
    }
    
    private void dfs(int[] nums, int parent, int level, int curSum, Map<Integer, Integer> map) {
        if(!map.containsKey(level)) {
            sum += curSum;
            return;
        }
        int size = map.containsKey(level + 1) ? map.get(level + 1) : nums.length;
        //System.out.println("level: " + level + "size: " + size);
        boolean end = true;
        int p_p = parent % 100 / 10;
        //System.out.println("P: "+p_p);
        for(int i = map.get(level); i < size; i++) {
            int c_p = nums[i] % 100 / 10;
            //System.out.println("C: "+c_p);
            if(p_p * 2 - 1 == c_p || p_p * 2 == c_p) {
                end = false;
                dfs(nums, nums[i], level + 1, curSum + (nums[i] % 10), map);
            }
        }
        if(end) sum += curSum;
    }
}


//         0
//     0       1
//  0   1     2   3
//0 1  2 3   4 5  6 7
//Regardless whether these nodes exist:

//the position of left child is always parent_pos * 2;
//the position of right child is alwaysparent_pos * 2 + 1;
//the position of parent is always child_pos / 2;

class Solution {

    public int pathSum(int[] nums) {
        int sum = 0;
        int[][] m = new int[5][8];
        for(int num: nums){
            int i = num / 100;
            int j = num % 100 / 10 - 1;
            int v = num % 10;
            m[i][j] = m[i - 1][j / 2] + v;
        }
        
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 8; j++) {
                if(i == 4 || m[i][j] != 0 && m[i + 1][j * 2] == 0 && m[i + 1][j * 2 + 1] == 0)
                    sum += m[i][j];
            }
        }
        
        return sum;
    }
}
