public class BankInterest {
    public interface Bank {
        void displayBalance();
        void displayInterestRate();
    }
    class BankA implements Bank {
        @Override
        public void displayBalance() {
            System.out.println("Bank A: Balance is $1000");
        }
        @Override
        public void displayInterestRate() {
            System.out.println("Bank A: Interest rate is 7.0%");
        }
    }
    class BankB implements Bank {
        @Override
        public void displayBalance() {
            System.out.println("Bank B: Balance is $150000");
        }
        @Override
        public void displayInterestRate() {
            System.out.println("Bank B: Interest rate is 7.4%");
        }
    }
    class BankC implements Bank {
        @Override
        public void displayBalance() {
            System.out.println("Bank C: Balance is $200000");
        }
        @Override
        public void displayInterestRate() {
            System.out.println("Bank C: Interest rate is 7.9%");
        }
    }
    public static void main(String[] args) {
        BankInterest bankInterest = new BankInterest();
        Bank bankA = bankInterest.new BankA();
        Bank bankB = bankInterest.new BankB();
        Bank bankC = bankInterest.new BankC();
        bankA.displayBalance();
        bankA.displayInterestRate();
        bankB.displayBalance();
        bankB.displayInterestRate();
        bankC.displayBalance();
        bankC.displayInterestRate();
    }
}
