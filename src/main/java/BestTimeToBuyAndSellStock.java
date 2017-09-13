/**
 * Created by Tapan on 9/2/2017.
 */
public class BestTimeToBuyAndSellStock {


    int maxProfitSoFar = 0;
    int maximumCurrent = 0;

    int calculate(int sharePrices[]) {
        for (int i = 1; i < sharePrices.length; i++) {
            maximumCurrent = maximumCurrent + (sharePrices[i] - sharePrices[i - 1]);
            if (maximumCurrent < 0) {
                maximumCurrent = 0;
            }
            if (maximumCurrent > maxProfitSoFar) {
                maxProfitSoFar = maximumCurrent;
            }
        }

        return maxProfitSoFar;
    }
}
