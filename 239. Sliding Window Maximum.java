public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || k <= 0) return new int[0];
        
        Deque<Integer> deque = new LinkedList<>();
        int n = nums.length;
        int[] res = new int[n - k + 1];  
        
        for(int i = 0; i < n; i++){
            // remove the element out of range
            while(!deque.isEmpty() && deque.peek() < i - k + 1){
                deque.poll();
            }
            // remove smaller numbers in k range as they are useless
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.pollLast();
            }
            
            deque.offer(i);
            int idx = i - k + 1;
            if(idx >= 0) res[idx] = nums[deque.peek()];
        }
        return res;
    }
}
