// greatest common divisor
// iterative:
int gcd(int a, int b) {
    while (b > 0) {
        int temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}
// recursive:
int generateGCD(int a,int b){

  if (b==0) return a;
  else return generateGCD(b,a%b);
}

public int gcd(int a, int b) {
    return b > 0 ? gcd(b, a % b) : a;
}


// lowest common multiple
int lcm(int a, int b) {
    return a * (b / gcd(a, b));
}


// long type
long gcd(long a, long b) {
    if (a == 0)
        return b;
    return gcd(b % a, a);
}

long lcm(long a, long b) {
    return a * b / gcd(a, b);
}
