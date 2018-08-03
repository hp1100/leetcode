class Solution {
    public int reverse(int x) {
        int sign = x > 0 ? 1 : -1;
        long res = 0;
        x = Math.abs(x);
        while (x > 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        res *= sign;
        return (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) ? 0 : (int)res;
    }
}

// Only 15 lines.
// If overflow exists, the new result will not equal previous one.
// No flags needed. No hard code like 0xf7777777 needed.
// Sorry for my bad english.

public int reverse(int x)
{
    int result = 0;

    while (x != 0)
    {
        int tail = x % 10;
        int newResult = result * 10 + tail;
        if ((newResult - tail) / 10 != result)
        { return 0; }
        result = newResult;
        x = x / 10;
    }

    return result;
}
