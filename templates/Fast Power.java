// a ^ b

public int fastPower(int a, int b) {
    int ans = 1;
    int base = a;
    while (b != 0) {
        if ((b & 1) != 0) { //如果当前的次幂数最后一位(二进制数)不为0的话，那么我们将当前权值加入到最后答案里面去
            ans = ans * base;
        }
        //权值增加
        base = base * base;
        b >>= 1;
    }
    return ans;
}

// a ^ n % b
public int fastPower(int a, int b, int n) {
    if (n == 0) {
        return 1 % b;
    }
    long ans = 1l;
    long base = a % b;
    while (n != 0) {
        if ((n & 1) == 1) {
            ans = (ans * base) % b;
        }
        //为了避免超出long的范围，所以取三次模
        base = (base % b) * (base % b) % b;
        n >>= 1;
    }
    return (int) ans;
}
