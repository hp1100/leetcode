class Solution {
    public boolean judgeCircle(String moves) {
        int[] coordinate = new int[2];
        for(int i = 0; i < moves.length(); i++){
            char m = moves.charAt(i);
            if(m == 'U'){
                coordinate[1]++;
            }else if(m == 'D'){
                coordinate[1]--;
            }else if(m == 'L'){
                coordinate[0]--;
            }else{
                coordinate[0]++;
            }
        }
        return (coordinate[0] == 0 & coordinate[1] == 0) ? true : false;
    }
}

// 2018.3.24
class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for(int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            if(c == 'U') y++;
            else if(c == 'D') y--;
            else if(c == 'L') x--;
            else if(c == 'R') x++;
        }
        return x == 0 && y == 0;
    }
}
