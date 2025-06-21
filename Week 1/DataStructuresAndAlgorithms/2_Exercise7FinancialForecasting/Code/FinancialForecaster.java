
public class FinancialForecaster {

    /**
     * Calculates future value recursively based on past values and growth rate
     *
     * @param pastValues Array of past values (most recent last)
     * @param periods Number of future periods to forecast
     * @return Array containing past values followed by forecasted values
     */
    public double[] forecast(double[] pastValues, int periods) {
        if (periods <= 0) {
            return pastValues;
        }

        double growthRate = calculateAverageGrowthRate(pastValues);

        // Calculate next value
        double nextValue = pastValues[pastValues.length - 1] * (1 + growthRate);

        // Create new array with the added forecasted value
        double[] newValues = new double[pastValues.length + 1];
        System.arraycopy(pastValues, 0, newValues, 0, pastValues.length);
        newValues[newValues.length - 1] = nextValue;

        // Recursively forecast remaining periods
        return forecast(newValues, periods - 1);
    }

    /**
     * Helper method to calculate average growth rate from past values
     *
     * @param values Array of past values
     * @return Average growth rate
     */
    private double calculateAverageGrowthRate(double[] values) {
        if (values.length < 2) {
            return 0.0; // Not enough data to calculate growth rate
        }

        double totalGrowth = 0.0;
        for (int i = 1; i < values.length; i++) {
            if (values[i - 1] != 0) {
                totalGrowth += (values[i] - values[i - 1]) / values[i - 1];
            }
        }

        return totalGrowth / (values.length - 1);
    }
}
