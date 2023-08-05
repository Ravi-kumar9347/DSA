class Solution {
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        //O(1) S(1)
        int round = purchaseAmount % 10;
        if(round >= 5) return 100 - (purchaseAmount + (10 - round));
        return 100 - (purchaseAmount - round);
    }
}