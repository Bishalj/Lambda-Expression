package practic;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        String ss = "My name is bishal";
        System.out.println(getTheReverseWordString(ss));
        System.out.println(getTheReverseWordString2(ss));
    }

    private static String getTheReverseWordString(String ss) {

        ss += " ";
        String reverseStr = "";
        String word = "";
        for(int i=0; i<ss.length(); i++){
            char character = ss.charAt(i);
            if(character != ' ')
                word = character + word;
            else {
                if(i == ss.length() -1)
                    reverseStr += word;
                else
                    reverseStr += word + " ";
                word = "";
            }
        }
        return reverseStr;
    }


    private static String getTheReverseWordString2(String ss) {
        String arr[] = ss.split(" ");
        String result = Arrays.asList(arr)
                .parallelStream()
                .map(word -> getTheReverseWord(word))
                .collect(Collectors.joining(" "));
        return result;
    }

    private static String getTheReverseWord(String word){
        StringBuilder stringBuilder = new StringBuilder(word);
        return stringBuilder.reverse().toString();
    }
}
