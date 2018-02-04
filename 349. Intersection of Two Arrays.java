// two hashset, Time complexity: O(n)

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for(int num : nums1)
            nums.add(num);
        for(int num : nums2)
            if(nums.contains(num))
                res.add(num);
        int[] ans = new int[res.size()];
        int idx = 0;
        for(int num: res)
            ans[idx++] = num;
        return ans;
    }
}

// binary search, Time complexity: O(nlogn)

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums2);
        for (Integer num : nums1) {
            if (binarySearch(nums2, num)) {
                set.add(num);
            }
        }
        int i = 0;
        int[] result = new int[set.size()];
        for (Integer num : set) {
            result[i++] = num;
        }
        return result;
    }
    
    public boolean binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
