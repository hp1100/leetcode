class Solution {
    // bit manipulation
    public List<String> readBinaryWatch(int num) {
        List<String> times = new LinkedList<>();
        for(int i = 0; i < (1 << 10); i++){
            if(Integer.bitCount(i) == num){
                StringBuilder sb = new StringBuilder();
                int hour = i >> 6;
                int min = i & 63;
                if(hour > 11 || min >= 60) continue;
                sb.append(hour + ":");
                if(min < 10)
                    sb.append("0" + min);
                else
                    sb.append(min);
                times.add(sb.toString());
            }
        }
        return times;
    }

}
