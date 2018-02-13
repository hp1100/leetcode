// basic binary search
// return index if exist else return -1
// no duplicate
public int binarySearch(int[] nums, int target){
	int lo = 0, hi = nums.length - 1;
	while(lo <= hi){
		int mid = (hi - lo) / 2 + lo;
		if(nums[mid] == target){
			return mid;
		}else if(nums[mid] < target){
			lo = mid + 1;
		}else{
			hi = mid - 1;
		}
	}
	return -1;
}
  
// find first element （lower_bound)
// Method 1: lo <= hi, hi = nums.length - 1
private int binarySearch(int[] nums, int target){
	int lo = 0, hi = nums.length - 1;
	while(lo <= hi){
		int mid = (hi - lo) / 2 + lo;
		if(nums[mid] < target)
			lo = mid + 1;
		else
			hi = mid - 1;
			
	}
	return lo;
}

// Method 2: lo < hi, hi = nums.length
private int binarySearch(int[] nums, int target){
	int lo = 0, hi = nums.length;
	while(lo < hi){
		int mid = (hi - lo) / 2 + lo;
		if(nums[mid] < target)
			lo = mid + 1;
		else
			hi = mid;
	}
	return lo;
}


  
// find last element (upper_bound)
private int binarySearch(int[] nums, int target){
	int lo = 0, hi = nums.length - 1;
	while(lo <= hi){
		int mid = (hi - lo) / 2 + lo;
		if(nums[mid] <= target)
			lo = mid + 1;
		else
			hi = mid - 1;
	}
	return lo;
}

// double / float
const double EPSLION = 1e-8;
