import java.util.Scanner;

public class CreditCardValidator {
    private String ccNumber;

    public CreditCardValidator(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    public void validateCard() {
        if (ccNumber.length() < 8 || ccNumber.length() > 9) {
            System.out.println("Invalid credit card number (must have 8 or 9 digits)");
            return;
        }

        int lastDigit = Character.getNumericValue(ccNumber.charAt(ccNumber.length() - 1));
        String remainingDigits = ccNumber.substring(0, ccNumber.length() - 1);
        System.out.println("Step a: Last digit = " + lastDigit + ", remaining number = " + remainingDigits);

        String reversedDigits = new StringBuilder(remainingDigits).reverse().toString();
        System.out.println("Step b: Reversed remaining digits = " + reversedDigits);

        int sum = 0;
        StringBuilder doubledDigits = new StringBuilder();
        for (int i = 0; i < reversedDigits.length(); i++) {
            int digit = Character.getNumericValue(reversedDigits.charAt(i));

            if (i % 2 == 0) {
                digit *= 2;
                if (digit > 9) {
                    digit = (digit / 10) + (digit % 10);
                }
            }
            sum += digit;
            doubledDigits.append(digit);
        }
        System.out.println("Step c: Digits after doubling odd positions = " + doubledDigits);
        
        System.out.println("Step d: Sum of all digits = " + sum);

        int calculatedCheckDigit = 10 - (sum % 10);
        if (calculatedCheckDigit == 10) {
            calculatedCheckDigit = 0;
        }
        System.out.println("Step e: Calculated check digit = " + calculatedCheckDigit);

        if (calculatedCheckDigit == lastDigit) {
            System.out.println("Step f: Valid credit card number");
        } else {
            System.out.println("Step f: Invalid credit card number");
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the credit card number: ");
        String ccNumber = scanner.nextLine();

        CreditCardValidator validator = new CreditCardValidator(ccNumber);
        validator.validateCard();
    }
}
