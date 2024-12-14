import java.util.*;

abstract class Robber {
    void displayClassName() {
        System.out.println("M.Sc. AI and ML");
    }
    
    abstract int robRowHouses(int[] houseMoney);
    abstract int robRoundHouses(int[] houseMoney);
    abstract int robSquareHouse(int[] houseMoneyGrid);
    abstract int robMultiHouseBuilding(int[][] buildingMoney);
    public void displayPassion() {
        System.out.println("I Love Machine Learning");
    }
}

class JAVAProfessionalRobber extends Robber {
    @Override
    public int robRowHouses(int[] houseMoney) {
        int houseCount = houseMoney.length;
        if (houseCount == 0) return 0;
        if (houseCount == 1) return houseMoney[0];
        int[] maxMoney = new int[houseCount];
        maxMoney[0] = houseMoney[0];
        maxMoney[1] = Math.max(houseMoney[0], houseMoney[1]);
        for (int i = 2; i < houseCount; i++) {
            maxMoney[i] = Math.max(maxMoney[i - 1], maxMoney[i - 2] + houseMoney[i]);
        }   
        return maxMoney[houseCount - 1];
    }

    @Override
    public int robRoundHouses(int[] houseMoney) {
        int houseCount = houseMoney.length;
        if (houseCount == 0) return 0;
        if (houseCount == 1) return houseMoney[0];
        int excludeFirst = robRowHouses(Arrays.copyOfRange(houseMoney, 1, houseCount));
        int excludeLast = robRowHouses(Arrays.copyOfRange(houseMoney, 0, houseCount - 1));
        return Math.max(excludeFirst, excludeLast);
    }

    @Override
    public int robSquareHouse(int[] houseMoneyGrid) {
        int evenSum = 0;
        int oddSum = 0;
        for (int i = 0; i < houseMoneyGrid.length; i++) {
            if (i % 2 == 0) {
                evenSum += houseMoneyGrid[i];
            } else {
                oddSum += houseMoneyGrid[i];
            }
        }
        return Math.max(evenSum, oddSum);
    }

    @Override
    public int robMultiHouseBuilding(int[][] buildingMoney) {
        int evenRowSum = 0;
        int oddRowSum = 0;

        for (int rowIndex = 0; rowIndex < buildingMoney.length; rowIndex++) {
            if (rowIndex % 2 == 0) {
                for (int colIndex = 0; colIndex < buildingMoney[rowIndex].length; colIndex++) {
                    evenRowSum += buildingMoney[rowIndex][colIndex];
                }
            } else {
                for (int colIndex = 0; colIndex < buildingMoney[rowIndex].length; colIndex++) {
                    oddRowSum += buildingMoney[rowIndex][colIndex];
                }
            }
        }
        return Math.max(evenRowSum, oddRowSum);
    }
}
    
class Lab4 {
    public static void main(String[] args) {
        JAVAProfessionalRobber robber = new JAVAProfessionalRobber();
        robber.displayClassName();
        
        int[] rowHouseMoney = {2, 4, 5, 6};
        System.out.println("Row Houses Maximum: " + robber.robRowHouses(rowHouseMoney));
        
        int[] roundHouseMoney = {3, 7, 8, 1};
        System.out.println("Round Houses Maximum: " + robber.robRoundHouses(roundHouseMoney));
        
        int[] squareHouseMoney = {2, 5, 7, 4};
        System.out.println("Square House Maximum: " + robber.robSquareHouse(squareHouseMoney));
        
        int[][] multiBuildingMoney = {
            {9, 3, 8, 3},
            {7, 12, 100, 6},
            {5, 10, 12, 5},
            {8, 6, 11, 7}
        };
        System.out.println("MultiHouse Building Maximum: " + robber.robMultiHouseBuilding(multiBuildingMoney));
        
        robber.displayPassion();
    }
}
