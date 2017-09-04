/**
 * Created by Tapan on 9/2/2017.
 */
public class BestTimeToBuyAndSellStock {


    int maxProfitSoFar = 0;
    int maximumCurrent = 0;
    int timeToBuy = -1;
    int timeToSell = -1;

    int calculate(int sharePrices[]) {
        for (int i = 1; i < sharePrices.length; i++) {
            maximumCurrent = maximumCurrent + (sharePrices[i] - sharePrices[i - 1]);
            if (maximumCurrent < 0) {
                maximumCurrent = 0;
            }
            if (maximumCurrent > maxProfitSoFar) {
                maxProfitSoFar = maximumCurrent;
                if (timeToBuy == -1) {
                    timeToBuy = i - 1;
                    timeToSell = i;
                } else  {
                    timeToSell = i;
                }
            }
        }
        System.out.println("Time to Buy:" + timeToBuy);
        System.out.println("Time to Sell:" + timeToSell);

        return maxProfitSoFar;
    }
}
