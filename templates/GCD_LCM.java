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


// lowest common multiple
int lcm(int a, int b) {
    return a * (b / gcd(a, b));
}