import java.util.Map;
import java.util.HashMap;

class ResistorColorDuo {

    private final String[] colors = {"black",
                        "brown",
                        "red",
                        "orange",
                        "yellow",
                        "green",
                        "blue",
                        "violet",
                        "grey",
                        "white"};
    
    private final Map<String, Integer> colorCodes = new HashMap<>();

    public ResistorColorDuo() {
        for(int i = 0; i < colors.length; i++) {
            colorCodes.put(colors[i], i);
        }
    }

    int value(String[] input) {

        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < 2; i++) {
            sb.append(colorCodes.get(input[i]));
        }
        
        return Integer.parseInt(sb.toString());
    }
}