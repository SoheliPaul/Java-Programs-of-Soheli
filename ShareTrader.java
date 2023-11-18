public class ShareTrader {
    static int maxProfit;
    static int buy1, sell1, buy2, sell2;

    public static int findMaxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            System.out.println("Not enough stock prices provided.");
            return 0;
        }

        buy1 = Integer.MIN_VALUE;
        sell1 = 0;
        buy2 = Integer.MIN_VALUE;
        sell2 = 0;

        for (int price : prices) {
            buy1 = Math.max(buy1, -price);
            sell1 = Math.max(sell1, buy1 + price);
            buy2 = Math.max(buy2, sell1 - price);
            sell2 = Math.max(sell2, buy2 + price);
        }

        maxProfit = sell2;
        return sell2;
    }

    public static void main(String[] args) {
        int[] prices1 = {10, 22, 5, 75, 65, 80};
        System.out.println("Maximum profit for prices1: " + findMaxProfit(prices1));

        int[] prices2 = {2, 30, 15, 10, 8, 25, 80};
        System.out.println("Maximum profit for prices2: " + findMaxProfit(prices2));
    }
}