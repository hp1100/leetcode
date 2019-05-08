class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int[] nums = new int[3];
        nums[0] = a;
        nums[1] = b;
        nums[2] = c;
        Arrays.sort(nums);
        a = nums[0];
        b = nums[1];
        c = nums[2];
        int max = 0, min = 0;
        System.out.print(a + ":" + b + ":" + c);
        max = c - a - 2;
        if (b - a == 1 && c - b == 1) min = 0;
        else if (b - a == 1 || c - b == 1 || b - a == 2 || c - b == 2) min = 1;
        else min = 2;
        return new int[]{min, max};
    }
}
