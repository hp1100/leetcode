class Solution {
    public boolean reorderedPowerOf2(int N) {
        for (int i = 0, c = counter(N); i < 32; i++)
            if (counter(1 << i) == c) return true;
        return false;
    }
    public int counter(int N) {
        int res = 0;
        for (; N > 0; N /= 10) res += (int)Math.pow(10, N % 10);
        return res;
    }
}
