class Solution {
    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) return false;
        A = A + A;
        return A.contains(B);
    }
}
