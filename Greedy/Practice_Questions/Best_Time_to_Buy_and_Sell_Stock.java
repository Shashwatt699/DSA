
public class Best_Time_to_Buy_and_Sell_Stock {

    public static int maxProfit(int[] prices) {
        int buyPrice = prices[0], MAXprofit = 0;

        for (int price : prices) {
            if (price < buyPrice) {
                buyPrice = price;
            }
            if (price - buyPrice > MAXprofit) {
                MAXprofit = price - buyPrice;
            }
        }

        return MAXprofit;
    }

    public static void main(String[] args) {
        int prices[] = { 7, 1, 5, 6, 4 };
        int n = prices.length;
        int max_profit = maxProfit(prices);
        System.out.println("The Maximum profit is : " + max_profit);
    }
}
