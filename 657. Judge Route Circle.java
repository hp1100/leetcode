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
