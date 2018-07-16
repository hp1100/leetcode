/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        int i,j;
        while ((i = rand7()) > 6);  // P(i is even) = P(i is odd) = 0.5
        while ((j = rand7()) > 5);  // P(j==1) = P(j==2) = P(j==3) = P(j==4) = P(j==5) = 0.2
        return (i & 1) == 1 ? j : j + 5;
    }
}
