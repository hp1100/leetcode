class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int[] nums = {a, b, c};
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

// 4 line solution
public int[] numMovesStones(int a, int b, int c) {
  int[] s = { a, b, c };
  Arrays.sort(s);
  if (s[2] - s[0] == 2) return new int[] { 0, 0 };
  return new int[] { Math.min(s[1] - s[0], s[2] - s[1]) <= 2 ? 1 : 2, s[2] - s[0] - 2 };
}
