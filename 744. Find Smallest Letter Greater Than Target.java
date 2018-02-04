class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int lo = 0, hi = letters.length - 1;
        while(lo + 1 < hi){
            int mid = (lo + hi) >>> 1;
            if(target - letters[mid] >= 0)
                lo = mid;
            else // target < letters[mid]
                hi = mid;
        }
        if(target < letters[lo]) lo--;
        if(target >= letters[hi]) lo++;
        return lo == letters.length - 1 ? letters[0] : letters[lo + 1];
    }
}
