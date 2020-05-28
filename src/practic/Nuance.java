package practic;

public class Nuance {
    public static void main(String[] args) {
        System.out.println(getTotalCandlesBurnt(6,2,2));
    }


    static int getTotalCandlesBurnt(int amount, int costOfCandle, int noOfResidueCandles) {
        int totalAmount= amount/costOfCandle;
        int tmpAmount = totalAmount;
        int mod = 0;
        while(tmpAmount >= noOfResidueCandles){
            mod =tmpAmount%noOfResidueCandles;
            tmpAmount = (tmpAmount)/noOfResidueCandles;
            totalAmount += tmpAmount;
            tmpAmount = tmpAmount+mod;
        }
        return totalAmount;
    }
}
