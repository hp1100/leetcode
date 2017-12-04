class Solution {
    public boolean isStrobogrammatic(String num) {
        if(num == null || num.length() == 0) return false;
        int end = num.length()/2, i = 0, len = num.length()-1;
        if(num.length() % 2 == 1 && num.charAt(end) != '0' && num.charAt(end) != '1' && num.charAt(end) != '8') 
            return false;
        while(i < end){
            if(num.charAt(i) == '1' && num.charAt(len - i) == '1') {i++;continue;}
            if(num.charAt(i) == '6' && num.charAt(len - i) == '9') {i++;continue;}
            if(num.charAt(i) == '9' && num.charAt(len - i) == '6') {i++;continue;}
            if(num.charAt(i) == '8' && num.charAt(len - i) == '8') {i++;continue;}
            if(num.charAt(i) == '0' && num.charAt(len - i) == '0') {i++;continue;}
            return false;
        }
        return true;
    }
}

// 4 line solution in java
class Solution {
    public boolean isStrobogrammatic(String num) {
        for(int i = 0, j = num.length()-1; i <= j; i++, j--)
            if(!"00 11 88 696".contains(num.charAt(i) + "" + num.charAt(j))) 
                return false;
        return true;
    }
}
