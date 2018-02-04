// two pointer:

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int lo = 0, hi = numbers.length - 1;
        while(lo < hi){
            if(numbers[lo] + numbers[hi] == target)
                break;
            else if(numbers[lo] + numbers[hi] > target)
                hi--;
            else
                lo++;
        }
        return new int[]{lo + 1, hi + 1};
    }
}

// binary search:
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for(int i = 0; i < numbers.length; i++){
            int j = binarySearch(numbers, i + 1, numbers.length - 1, target - numbers[i]);
            if(j != -1)
                return new int[]{i + 1, j + 1};
        }
        return new int[]{-1, -1};
    }
    
    private int binarySearch(int[] numbers, int lo, int hi, int target){
        while(lo <= hi){
            int mid = (lo + hi) >>> 1;
            if(numbers[mid] == target){
                return mid;
            }else if(numbers[mid] < target){
                lo = mid + 1;
            }else{
                hi = mid - 1;
            }
        }
        return -1;
    }
}
