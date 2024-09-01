class gift {
    public static void main(String args[]) {
        newi ne = new newi();
        System.out.println(ne.giveans());
    }    
}

class newi {
    int res = Integer.MIN_VALUE;
    public int giveans () {
        int vouchers[] = {60, 100, 150};
        int prices[] = {100, 120, 160};
        int budget = 200;
        int cnt = 0;

        for (int i = 0; i < prices.length; i++) 
            helper(vouchers, prices, budget, cnt, i);

        return res;
    }

    public void helper(int vouchers[], int prices[], int rem_budget, int cnt, int idx) {
        if (idx >= prices.length) {
            res = Math.max(res, cnt);
            //System.out.println(cnt);
            return;
        }

        if (rem_budget >= prices[idx])
            helper(vouchers, prices, rem_budget - prices[idx], cnt + vouchers[idx], idx + 1);
        
        helper(vouchers, prices, rem_budget, cnt, idx + 1);

        return;
    }

}