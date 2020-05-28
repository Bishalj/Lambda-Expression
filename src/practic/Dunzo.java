package practic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dunzo {

    public static void main(String[] args) {
        long initialEnergy = 1999;
        List<Integer> energy = new ArrayList<>(
                Arrays.asList(12,2,2)
        );

        List<Integer> coins = new ArrayList<>(
                Arrays.asList(5,5,5)
        );
        System.out.println(getRich(initialEnergy, energy, coins));
    }

    public static int getRich(long initialEnergy, List<Integer> energy, List<Integer> coins) {
        // Write your code here
        int arr[][] = new int[energy.size()][energy.size()];
        int maxCoins =  getRich(initialEnergy, energy, coins, 0, arr);
        return maxCoins == -1 ? 0 : maxCoins;



    }


    public static int getRich(long initialEnergy, List<Integer> energy, List<Integer> coins, int position, int arr[][]) {
        // Write your code here
        if(position == energy.size())
            return 0;
        else if(initialEnergy < 0)
            return -1;
        else if(initialEnergy  >= energy.size()-1) {
            int processedValue = getProcessedValue(arr, initialEnergy, position);
            if (processedValue == -1)
                return -1;
            else if(processedValue != 0)
                return processedValue;
            else {
                int data = getRich(initialEnergy - 1, energy, coins, position + 1, arr) + coins.get(position);
                arr[position][arr.length-1] = data;
            }
        }

        int data = getProcessedValue(arr, initialEnergy, position);
        if(data == -1)
            return -1;
        else if(data != 0)
            return data;


        int includingSum = getRich(initialEnergy-1, energy, coins, position+1, arr);

        if(includingSum == -1) {
            includingSum = coins.get(position);
        }
        else {
            includingSum += coins.get(position);
        }

        int excludingSum = getRich(initialEnergy+energy.get(position)-1, energy, coins, position+1, arr);
        int max = Math.max(includingSum, excludingSum);

        arr[position][(int)initialEnergy] = Math.max(arr[position][(int)initialEnergy], max);
        return max;
    }

    private static int getProcessedValue(int[][] arr, long initialEnergy, int position) {
        if(initialEnergy >= arr.length-1)
            return arr[position][arr.length-1];
        else
            return arr[position][(int)initialEnergy];
    }


}
