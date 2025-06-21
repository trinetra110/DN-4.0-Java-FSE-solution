
public class Test {

    public static void main(String[] args) {
        FinancialForecaster forecaster = new FinancialForecaster();

        // Sample past quarterly revenue data (in millions)
        double[] pastRevenue = {12.5, 13.2, 14.1, 15.0, 16.2};

        System.out.println("Past Revenue Data:");
        printArray(pastRevenue);

        System.out.println("\nForecasting next 3 periods using average growth rate:");
        double[] forecast = forecaster.forecast(pastRevenue, 3);
        printArray(forecast);
    }

    private static void printArray(double[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i < array.length - 1) {
                System.out.printf("%.2f, ", array[i]);
            } else {
                System.out.printf("%.2f%n", array[i]);
            }
        }
    }
}
