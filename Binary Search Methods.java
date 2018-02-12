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
  
// find first element
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

private static int binarySearch(int[] nums, int target){
	int lo = 0, hi = nums.length - 1;
	while(lo < hi){
		int mid = (hi - lo) / 2 + lo;
		if(nums[mid] < target)
			lo = mid + 1;
		else
			hi = mid;
	}
	return lo;
}


  
// find last element
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
