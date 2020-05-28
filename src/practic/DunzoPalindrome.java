package practic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DunzoPalindrome {

    public static void main(String[] args) {
        String word = "aaaa";
        System.out.println(threePalindromicSubstrings(word).toString());
    }

    public static List<String> threePalindromicSubstrings(String word) {
        int characterIndex =word.indexOf(word.charAt(0), 1);
        if(characterIndex == -1)
            return new ArrayList<>(Arrays.asList("Impossible"));

        int counter = 0;
        int startIndex = 0;
        List<String> palindromes = new ArrayList<>();
        while (characterIndex <= word.length()-1){

            if(isSubStringPalindrome(startIndex, characterIndex, word)){
                if(counter<2 && characterIndex-startIndex == 1 && word.charAt(characterIndex) == word.charAt(startIndex)){
                    characterIndex = startIndex;
                }else {
                    characterIndex++;
                    startIndex = characterIndex;
                }
                palindromes.add(word.substring(startIndex, characterIndex + 1));
                counter++;
                if(counter == 4)
                    break;
            }

            if(characterIndex+1 >= word.length())
                break;
            characterIndex = word.indexOf(word.charAt(characterIndex), characterIndex+ 1);
            if(characterIndex == -1)
                break;
        }

        if(counter != 3)
            return  new ArrayList<>(Arrays.asList("Impossible"));
        // Write your code here
        return palindromes;
    }

    private static boolean isSubStringPalindrome(int startIndex, int characterIndex, String word) {
        while (startIndex++ < characterIndex--){
            if(word.charAt(startIndex) != word.charAt(characterIndex))
                return false;
        }
        return true;
    }
}
