class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int bill: bills) {
            if (bill == 5) {
                five++;
            }else if(bill == 10) {
                if (--five < 0) 
                    return false;
                ten++;
            }else { // bill = 20
                int dis = 3;
                if (ten > 0) {
                    ten--;
                    dis -= 2;
                }
                if (five - dis < 0)
                    return false;
                five -= dis;
            }
        }
        return true;
    }
}
