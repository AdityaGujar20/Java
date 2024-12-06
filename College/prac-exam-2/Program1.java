interface TransactionPairs {
    int countPairsWithSum(int[] arr, int target);
}

class TransactionData implements TransactionPairs {

    public int countPairsWithSum(int[] arr, int target) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    System.out.println("Pair found: (" + arr[i] + "," + arr[j] + ")");
                    count++;
                }
            }
        }
        return count;
    }
}

public class Program1 {
    public static void main(String[] args) {
        TransactionData tp = new TransactionData();

        int[] arr1 = { 3, 5, 7, 1, 2, 10 };
        int target1 = 10;
        System.out.println("Array 1");
        int pairCount1 = tp.countPairsWithSum(arr1, target1);
        System.out.println("Number of pairs found in Array 1: " + pairCount1);

        System.out.println("-------------------------------------------------");

        int[] arr2 = { 2, 4, 3, 5, 6 };
        int target2 = 8;
        System.out.println("Array 2");
        int pairCount2 = tp.countPairsWithSum(arr2, target2);
        System.out.println("Number of pairs found in Array 2: " + pairCount2);
    }
}