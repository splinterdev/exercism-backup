import java.util.List;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

class Scrabble {

    private int score = 0;
    private Map<List<String>, Integer> wordValues = new HashMap<>(Map.of(Arrays.asList("aeioulnrst".split("")), 1,
                                                                 Arrays.asList("dg".split("")), 2,
                                                                 Arrays.asList("bcmp".split("")), 3,
                                                                 Arrays.asList("fhvwy".split("")), 4,
                                                                 Arrays.asList("k".split("")), 5,
                                                                 Arrays.asList("jx".split("")), 8,
                                                                 Arrays.asList("qz".split("")), 10));
    
    Scrabble(String word) {

        for(int i = 0; i < word.length(); i++) {
            
            char c = Character.toLowerCase(word.charAt(i));
            
            wordValues.forEach((k, v) -> {
                if(k.contains(String.valueOf(c))) {
                    score += v;
                }
            });
        }
    }

    int getScore() {
        return score;
    }
}
