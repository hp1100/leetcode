class Solution {
    public boolean validWordSquare(List<String> words) {
        if(words == null || words.size() == 0) return true;
        for(int i = 0; i < words.size(); i++){
            for(int j = 0; j < words.get(i).length(); j++){
                if(j >= words.size() || words.get(j).length() <= i || words.get(j).charAt(i) != words.get(i).charAt(j))
                    return false;
            }
        }
        return true;
    }
}
