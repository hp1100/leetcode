public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] doubleNums = new int[nums.length * 2];
        for(int i = 0, j = nums.length; i < nums.length; i++, j++){
            doubleNums[i] = doubleNums[j] = nums[i];
        }
        //for(int num: doubleNums) System.out.print(num);
        Map<Integer, List<Integer>> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int num: doubleNums){
            while(!stack.isEmpty() && stack.peek() < num){
                //if(map.containsKey(stack.peek())) break;
                int key = stack.pop();
                if(map.containsKey(key)){
                    map.get(key).add(num);
                }else{
                    List<Integer> list = new LinkedList<Integer>();
                    list.add(num);
                    map.put(key, list);
                }
                //map.put(key, map.getOrDefault(key, new LinkedList<Integer>()).add(num));
            }
            stack.push(num);
        }
        for(int i = 0; i < nums.length; i++){
            //nums[i] = map.getOrDefault(nums[i], -1);
            if(map.containsKey(nums[i])){
                int temp = map.get(nums[i]).get(0);
                map.get(nums[i]).remove(0);
                nums[i] = temp;
            }else{
                nums[i] = -1;
            }
        }
        return nums;
    }
}
