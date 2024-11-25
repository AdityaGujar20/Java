public class WaterConservation {
    public interface WaterConservationSystem {
        int calculateTrappedWater(int[] heights);
    }

    static abstract class RainySeasonConservation implements WaterConservationSystem {
    }

    static class UrbanWaterConservation extends RainySeasonConservation {
        @Override
        public int calculateTrappedWater(int[] heights) {
            if (heights == null || heights.length < 3) {
                System.out.println("Insufficient blocks to trap water.");
                return 0;
            }

            int numBlocks = heights.length;
            int[] maxHeightLeft = new int[numBlocks];
            int[] maxHeightRight = new int[numBlocks];

            maxHeightLeft[0] = heights[0];
            for (int i = 1; i < numBlocks; i++) {
                maxHeightLeft[i] = Math.max(maxHeightLeft[i - 1], heights[i]);
            }

            maxHeightRight[numBlocks - 1] = heights[numBlocks - 1];
            for (int i = numBlocks - 2; i >= 0; i--) {
                maxHeightRight[i] = Math.max(maxHeightRight[i + 1], heights[i]);
            }

            int totalTrappedWater = 0;
            for (int i = 0; i < numBlocks; i++) {
                totalTrappedWater += Math.min(maxHeightLeft[i], maxHeightRight[i]) - heights[i];
            }

            System.out.println("Trapped water: " + totalTrappedWater + " units");
            return totalTrappedWater;
        }
    }

    public static void main(String[] args) {
        int[] blockHeights = {3, 0, 2, 0, 6};

        UrbanWaterConservation waterConservationSystem = new UrbanWaterConservation();

        int trappedWater = waterConservationSystem.calculateTrappedWater(blockHeights);
        System.out.println("Total volume of trapped water: " + trappedWater + " units");
    }
}
