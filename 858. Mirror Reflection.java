// If p = odd, q = even: return 0
// If p = even, q = odd: return 2
// If p = odd, q = odd: return 1
// I summary it as return 1 - p % 2 + q % 2
class Solution {
    public int mirrorReflection(int p, int q) {
        while (p % 2 == 0 && q % 2 == 0) {p >>= 1; q >>= 1;}
        return 1 - p % 2 + q % 2;
    }
}
