import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Collection;

public class ResistorColor {

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

    public ResistorColor() {
        for(int i = 0; i < colors.length; i++) {
            colorCodes.put(colors[i], i);
        }
    }
    
    public int colorCode(String color) {
        return colorCodes.get(color);
    }

    public String[] colors() {
        return colors;
    }
}
