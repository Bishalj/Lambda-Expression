package practic;

import java.util.*;
import java.util.stream.Collectors;

public class Amazon {
    public static void main(String[] args) {
        List<String> possibleFeatures = new ArrayList<>(
                Arrays.asList("Storage", "battery", "hover", "Alexa", "waterproof", "solar")
        );
        List<String> featureRequests = new ArrayList<>(
                Arrays.asList(
                        "I wish storage",
                        "on my hover desk",
                        "on my hover desk",
                        "i wish battery",
                        "i enjoy waterproof",
                        "Waterproof and increased battery",
                        "Waterproof please waterproof",
                        "via solar power"
                )
        );

        List<String> data = popularNFeatures(6,2,possibleFeatures, 7, featureRequests);
        System.out.println(data.toString());

        Amazon amazon = new Amazon();
        List<Character> characters = new ArrayList<>(
                Arrays.asList('a','b','a','b','c','b','a','c','a','d','e','f','e','g','d','e','h','i','j','h','k','l','i','j')
        );

        List<Character> characterss = new ArrayList<>(Arrays.asList('a','b','c'));
        List<Integer> ll = amazon.lengthEachScene(characters);
        System.out.println(ll);

    }

    /*
    * @Method: popularNFeatures - returns list of popular N Features
    *
    * @Params
    *  numFeatures
    *  topFeatures
    *  possibleFeatures
    *  numFeatureRequests
    *  featureRequests
    *
    * @Approach
    *
    * 1. Create a Set<String> of all possible features in lower case
    * 2. Traverse the featureRequests list
    *      i. Split current featureRequest by space character to get the words array.
    *      ii. Create a Set to store the already visited words of the current featureRequest.
    *      iii.
    *
    *
    * */
    public static ArrayList<String> popularNFeatures(int numFeatures,
                                              int topFeatures,
                                              List<String> possibleFeatures,
                                              int numFeatureRequests,
                                              List<String> featureRequests)
    {

        Map<String, Integer> resultMap = new HashMap();

        possibleFeatures =
                possibleFeatures
                .parallelStream()
                .map(feature -> feature.toLowerCase())
                .collect(Collectors.toList());
        Set<String> keywords = new HashSet<>(possibleFeatures);
        for(String request: featureRequests){
            Set<String> processedWords = new HashSet<>();
            String[] words = request.split(" ");
            fequencyCountOfWords(resultMap, keywords, processedWords, words);
        }
        List<Map.Entry<String, Integer>> tmpList = new ArrayList<>(resultMap.entrySet());
        Comparator<Map.Entry<String, Integer>> comparator = getTheSortedComparator();

        Collections.sort(tmpList, comparator);
        ArrayList<String> topFeaturesResult = new ArrayList<>(topFeatures);
        for(int i=0; i<topFeatures && i<tmpList.size(); i++){
            topFeaturesResult.add(tmpList.get(i).getKey());
        }

        return topFeaturesResult;
    }

    /*
     * @Method: popularNFeatures - returns list of popular N Features
     *
     * @Params
     *  numFeatures
     *  topFeatures
     *  possibleFeatures
     *  numFeatureRequests
     *  featureRequests
     *
     * @Approach
     *
     * 1. Create a Set<String> of all possible features in lower case (allPossibleFeatures)
     * 2. Create a Map<String, Integer> to store word and its occurring frequency (frequencyMap)
     * 3. Traverse the featureRequests list
     *      i. Split current featureRequest by space character to get the words array.
     *      ii. Create a Set to store the already visited words of the current featureRequest. (alreadyVisitedSet)
     *      iii. Traverse the words array created
     *              a. Convert the current word to lowercase
     *              b. Check if the current word is a possible feature in the Set of allPossibleFeatures
     *                  if the current word is present
     *                      then check if the current word is already visited or not in the alreadyVisitedSet
     *                          if the current word is not visited
     *                              then
     *                                  increment the frequency of the current word in the frequencyMap
     *                                  also add the current word in the alreadyVisitedSet
     *
     * 4. Sort the frequencyMap based on value in descending order
     * 5 Traverse the frequencyMap
     * 5. Get the first topFeatures elements from the frequencyMap and store it in a list and return the list,
     *    if the value of topFeatures is greater than size of frequencyMap then convert the
     *
     *
     * */
    private static void fequencyCountOfWords(Map<String, Integer> resultMap, Set<String> keywords, Set<String> processedWords, String[] words) {
        for(String word: words){
            word = word.toLowerCase();
            if(keywords.contains(word)){
                if(processedWords.contains(word) == false) {
                    if (resultMap.containsKey(word))
                        resultMap.put(word, resultMap.get(word) + 1);
                    else
                        resultMap.put(word, 1);
                    processedWords.add(word);
                }
            }
        }
    }

    private static Comparator<Map.Entry<String, Integer>> getTheSortedComparator() {
        return new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    if(o1.getValue() == o2.getValue()){
                        return o1.getKey().compareTo(o2.getKey());
                    }
                    return  o2.getValue() > o1.getValue() ? 1:-1;
                }
            };
    }

    /*
    * Method lengthEachScene
    * return the length of each scene
    *
    * Approach:
    * Store the last occurring index of each character of the input in a Hashmap<Character, Integer>
    * Take two variables startIndex and endIndex
    * Initialize
    * startIndex = 0;
    * endIndex = The last occurring index of element at position 0
    *
    * Traverse the inputList starting from 0 till the end element : loop variable currentIndex
    * if the end index is equals to the currentIndex
    *   then add the scene length in the output list as endIndex - startIndex + 1
    *        change the startIndex value to endIndex +1
    *        and check if startIndex < inputList size
    *           then search for the last occurring index of the next element in the map created before and
    *            store it as the end Index
    * else
    *    search for the last occurring index of the current element in the map created before and
     *         if the index is greater than endIndex then replace the endIndex value with the searched value
    *
    * */

    private List<Integer> lengthEachScene(List<Character> inputList)
    {
        if(inputList == null || inputList.isEmpty())
            return Collections.emptyList();
        final List<Integer> sceneLengths = new ArrayList<>();
        final Map<Character, Integer> characterEndIndexMap = getTheEndIndexMap(inputList);
        int endIndex = characterEndIndexMap.get(inputList.get(0));
        int startIndex = 0;
        calculateTheSceneLength(inputList, sceneLengths, characterEndIndexMap, endIndex, startIndex);
        return sceneLengths;
    }

    private void calculateTheSceneLength(List<Character> inputList, List<Integer> sceneLengths, Map<Character, Integer> characterEndIndexMap, int endIndex, int startIndex) {
        for(int i=0; i<inputList.size(); i++){
            Character character = inputList.get(i);
            if(i == endIndex){
                sceneLengths.add(endIndex-startIndex+1);
                startIndex = endIndex + 1;
                if(startIndex < inputList.size())
                    endIndex = characterEndIndexMap.get(inputList.get(startIndex));
            }else{
                int currentEndIndex = characterEndIndexMap.get(character);
                if(currentEndIndex > endIndex)
                    endIndex = currentEndIndex;
            }
        }
    }

    private Map<Character, Integer> getTheEndIndexMap(List<Character> inputList) {

        Map<Character, Integer> characterEndIndexMap = new HashMap<>();
        for(int i=0; i<inputList.size(); i++){
            Character character= inputList.get(i);
            characterEndIndexMap.put(character, i);
        }
        return characterEndIndexMap;
    }


}