// O(2^n) time complexity
class Solution {
    
    int res;
    
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        res = Integer.MAX_VALUE;
        backtrack(price, special, needs, 0, 0);
        return res;
    }
    
    private void backtrack(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int idx, int curPrices) {
        if (idx == special.size() * 6) {
            for (int i = 0; i < needs.size(); i++)
                curPrices += needs.get(i) * price.get(i);
            res = Math.min(curPrices, res);
            return;
        }
        List<Integer> offer = special.get(idx % special.size());
        int cost = buyOffer(needs, offer);
        if (cost >= 0) {
            backtrack(price, special, newNeeds(needs, offer), idx + 1, curPrices + cost);
        }
        backtrack(price, special, needs, idx + 1, curPrices);
    }
    
    private int buyOffer(List<Integer> needs, List<Integer> offer) {
        //if (needs.size() != offer.size() - 1) return false;
        int i;
        for (i = 0; i < needs.size(); i++)
            if (needs.get(i) < offer.get(i)) return -1;
        return offer.get(i);
    }
    
    private List<Integer> newNeeds(List<Integer> needs, List<Integer> offer) {
        List<Integer> tmp = new ArrayList<>(needs);
        for (int i = 0; i < tmp.size(); i++)
            tmp.set(i, tmp.get(i) - offer.get(i));
        return tmp;
    }
}
