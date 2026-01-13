import java.util.List;
import java.util.ArrayList;

public class PangramChecker {

    public boolean isPangram(String input) {

        List<String> alphabet = List.of(
    "a","b","c","d","e","f","g","h","i","j",
    "k","l","m","n","o","p","q","r","s","t",
    "u","v","w","x","y","z"
        );

        List<String> inputAsList = new ArrayList(); 

        String cleanedInput = input.replaceAll("[^a-zA-Z]", "").toLowerCase();

        for(int i = 0; i < cleanedInput.length(); i++) {
            inputAsList.add(String.valueOf(cleanedInput.charAt(i)));
        }
        
        return inputAsList.containsAll(alphabet);
    }
}
