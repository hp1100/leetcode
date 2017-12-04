class Solution {
    public String addStrings(String num1, String num2) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--){
            int tmp = 0;
            if(i >= 0) tmp += Integer.parseInt(num1.charAt(i)+"");
            if(j >= 0) tmp += Integer.parseInt(num2.charAt(j)+"");
            tmp += carry;
            carry = tmp / 10;
            sb.append(tmp % 10);
        }
        return sb.reverse().toString();
    }
}
