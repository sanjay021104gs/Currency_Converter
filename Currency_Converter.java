import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class CurrencyConverter {
    private double balance;
    private String baseCurrency;
    private Map<String, BigDecimal> exchangeRates;

    public CurrencyConverter(double balance, String baseCurrency, Map<String, BigDecimal> exchangeRates) {
        this.balance = balance;
        this.baseCurrency = baseCurrency;
        this.exchangeRates = exchangeRates;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public Map<String, BigDecimal> getExchangeRates() {
        return exchangeRates;
    }

    public void setExchangeRates(Map<String, BigDecimal> exchangeRates) {
        this.exchangeRates = exchangeRates;
    }

    public String convertCurrency(String targetCurrency, double amount) {
        if (!exchangeRates.containsKey(targetCurrency)) {
            return "Exchange rate for " + targetCurrency + " not available.";
        }

        BigDecimal exchangeRate = exchangeRates.get(targetCurrency);
        BigDecimal convertedAmount = new BigDecimal(Double.toString(amount)).multiply(exchangeRate);
        return "Successfully converted " + amount + " " + baseCurrency + " to " + convertedAmount + " " + targetCurrency + ".";
    }
}

public class Currency_Converter{
    public static void main(String[] args) {
        Map<String, BigDecimal> exchangeRates = new HashMap<>();
        exchangeRates.put("USD", new BigDecimal("0.84"));
        exchangeRates.put("EUR", new BigDecimal("0.96"));
        exchangeRates.put("GBP", new BigDecimal("1.13"));

        CurrencyConverter currencyConverter = new CurrencyConverter(500, "USD", exchangeRates);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the amount to convert: ");
        double amount = scanner.nextDouble();

        System.out.println("Enter the target currency (USD, EUR, GBP): ");
        String targetCurrency = scanner.next();

        System.out.println(currencyConverter.convertCurrency(targetCurrency, amount));

        scanner.close();
    }
}