class Solution {
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        String[] units = {"", " Thousand ", " Million ", " Billion "};
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            int temp = num % 1000;
            num /= 1000;
            String next = helper(temp);
            if (next.length() != 0)
                sb.insert(0, helper(temp) + units[idx++]);
            else
                idx++;
        }
        return sb.toString().trim();
    }
    
    private String helper(int temp) {
        String[] s1 = {"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", 
                       "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] s2 = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] s3 = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
        StringBuilder sb = new StringBuilder();
        if (temp >= 100) {
            sb.append(s3[temp / 100 - 1]).append(" ").append("Hundred").append(" ");
            temp %= 100;
        }
        if (temp >= 20) {
            sb.append(s2[temp / 10 - 2]).append(" ");
            temp %= 10;
        }
        if (temp > 10) {
            sb.append(s1[temp - 11]).append(" ");
            temp = 0;
        }
        if (temp > 0) {
            sb.append(s3[temp - 1]).append(" ");
        }
        return sb.toString().trim();
    }
}
