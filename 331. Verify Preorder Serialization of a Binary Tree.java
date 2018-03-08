
// full tree : number of leaves = number of non-leaves + 1

class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int count = 0, i;
        for(i = 0; i < nodes.length && count * 2 - 1 < i; i++) 
            if(nodes[i].equals("#"))
                count++;
        System.out.println(count+ "!"+ i);
        return count * 2 - 1 == nodes.length && i == nodes.length;
    }
}
