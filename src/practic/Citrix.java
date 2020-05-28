package practic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Citrix {

    public static void main(String[] args) {
        List<Integer> songs = new ArrayList<>(
                Arrays.asList(60,60,60)
        );
        System.out.println(playlist(songs));

    }

    public static long playlist(List<Integer> songs) {
        // Write your code here
       long c = getTheCount(songs);
       return c;
    }

    private static int getTheCount(List<Integer> songs) {
        int[] timeFrame = new int[60];
        int numberOfPairs = 0;
        for (int aSong : songs){
            int modValue = aSong % 60;
            int differenceValue = modValue == 0 ? 0 : 60 - modValue;
            numberOfPairs += timeFrame[differenceValue];
            timeFrame[modValue]++;
        }

        return numberOfPairs;
    }
}
