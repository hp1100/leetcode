// basic binary search
// return index if exist else return insert place
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
	return lo;
}


// return first index if exist else return insert place
// contain duplicate
private int findFirstInsertPlace(int[] nums, int target) {
	int lo = 0, hi = nums.length - 1;
	while (lo <= hi) {
	    int mid = (hi - lo) / 2 + lo;
	    if (nums[mid] >= target) {
		hi = mid - 1;
	    } else {
		lo = mid + 1;
	    }
	}
	return lo;
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

// Method 2.1: lo < hi, hi = nums.length
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

// Method 2.2: lo < hi, hi = nums.length
private int binarySearch(int[] nums, int target){
	int lo = 0, hi = nums.length;
	while(lo < hi){
		int mid = (hi - lo) / 2 + lo + 1;
		if(nums[mid] > target)
			hi = mid - 1;
		else
			lo = mid;
	}
	return hi;
}

// LintCode 14: First Position of Target(return -1 if target does not exsits in array)
public int binarySearch(int[] nums, int target) {
	//write your code here
	int lo = 0, hi = nums.length - 1;
	while(lo + 1 < hi){
	    int mid = (hi - lo) / 2 + lo;
	    if(target < nums[mid]){
		hi = mid;
	    }else if(target == nums[mid]){
		hi = mid;
	    }else{
		lo = mid;
	    }
	}
	if(nums[lo] == target) return lo;
	if(nums[hi] == target) return hi;
	return -1;
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
	return hi; // shan bro's contribute
}




// double / float
const double EPSLION = 1e-8;
