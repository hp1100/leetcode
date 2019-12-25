class Solution {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        
        Stack<Integer> stack = new Stack<>();
        
        int carry = 0, i = arr1.length - 1, j = arr2.length - 1;
        
        while (i >= 0 || j >= 0 || carry != 0) {
            if (i >= 0) carry += arr1[i--];
            if (j >= 0) carry += arr2[j--];
            stack.push(carry & 1);
            carry = -(carry >> 1);
        }
        
        while (stack.size() > 1 && stack.peek() == 0)
            stack.pop();
        
        int[] res = new int[stack.size()];
        for (int k = 0; k < res.length; k++)
            res[k] = stack.pop();
        return res;
    }
}
