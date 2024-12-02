public class program1 {

    static int includeResult = 0;
    static int excludeResult = 0;

    
    static int countCombinations(int[] coins, int n, int sum) {
        
        if (sum == 0) return 1;

        
        if (sum < 0 || n <= 0) return 0;

        
        return countCombinations(coins, n, sum - coins[n - 1]) +
               countCombinations(coins, n - 1, sum);
    }

    
    static class IncludeThread extends Thread {
        int[] coins;
        int n;
        int sum;

        IncludeThread(int[] coins, int n, int sum) {
            this.coins = coins;
            this.n = n;
            this.sum = sum;
        }

        @Override
        public void run() {
            includeResult = countCombinations(coins, n, sum - coins[n - 1]);
        }
    }

    static class ExcludeThread extends Thread {
        int[] coins;
        int n;
        int sum;

        ExcludeThread(int[] coins, int n, int sum) {
            this.coins = coins;
            this.n = n;
            this.sum = sum;
        }

        @Override
        public void run() {
            excludeResult = countCombinations(coins, n - 1, sum);
        }
    }


    static int count(int[] coins, int sum) throws InterruptedException {
        int n = coins.length;

        IncludeThread includeThread = new IncludeThread(coins, n, sum);
        ExcludeThread excludeThread = new ExcludeThread(coins, n, sum);

        includeThread.start();
        excludeThread.start();

        
        includeThread.join();
        excludeThread.join();

        
        return includeResult + excludeResult;
    }

    public static void main(String[] args) throws InterruptedException {
        
        int[] coins1 = {1, 2, 3};
        int sum1 = 4;
        System.out.println("Number of combinations (Example 1): " + count(coins1, sum1));

        
        int[] coins2 = {2, 5, 3, 6};
        int sum2 = 10;
        System.out.println("Number of combinations (Example 2): " + count(coins2, sum2));
    }
}
