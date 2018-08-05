class Solution {
    public String decodeAtIndex(String S, int K) {
        long N = 0L;
        int i;
        for (i = 0; N < K; i++) 
            N = Character.isDigit(S.charAt(i)) ? N * (S.charAt(i) - '0') : N + 1;
        i--;
        while (true) {
            if (Character.isDigit(S.charAt(i))) {
                N /= S.charAt(i) - '0';
                K %= N;
            } else if (K % N == 0) 
                return "" + S.charAt(i);
            else 
                N--;
            i--;
        }
    }
}
