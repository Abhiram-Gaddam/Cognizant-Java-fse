public class FinancialForecasting {
    public static void main(String[] args) {
        double initialAmount = 10000;  
        double growthRate = 0.10;    
        int years = 5;

        double futureValue = calculateFutureValue(initialAmount, growthRate, years);
        System.out.printf("Future Value after %d years: %.2f\n", years, futureValue);
    }

    public static double calculateFutureValue(double initial, double rate, int years) {
        if (years == 0) {
            return initial;
        }
        return calculateFutureValue(initial, rate, years - 1) * (1 + rate);
    }
}