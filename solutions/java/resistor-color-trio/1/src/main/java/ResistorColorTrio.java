import java.util.Map;
import java.util.HashMap;

class ResistorColorTrio {

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

    public ResistorColorTrio() {
        for(int i = 0; i < colors.length; i++) {
            colorCodes.put(colors[i], i);
        }
    }
    
    String label(String[] input) {

        String value = new String();

        for(int i = 0; i < 3; i++) {

            int code = colorCodes.get(input[i]);
            
            if(i == 2) {
                for(int j = 0; j < code; j++) {
                    value += 0;
                }
            } else if(i == 0 && code == 0) {
                continue;
                
            } else {
                value += code;
            }
        }

        String finalValue = metricPrefix(value);
        
        return finalValue;
    }

    private String metricPrefix(String value) {

        int BILION = 1_000_000_000;
        int MILION = 1_000_000; 
        int THOUSAND = 1_000; 
        
        String finalValue = new String();
        long intValue = Long.parseLong(value);
        
        if(intValue > BILION) {
            finalValue = value.replace("0", "");
            finalValue += " gigaohms";
            
        } else if(intValue > MILION) {
            finalValue = value.replace("0", "");
            finalValue += " megaohms";
            
        } else if(intValue > THOUSAND) {
            
            if(intValue >= 100_000) {
                finalValue = value.substring(0, value.indexOf("0") + 1);
                
            } else if(intValue >= 10_000) {
                finalValue = value.substring(0, value.indexOf("0"));
                
            } else {
                finalValue = value.replace("0", "");
            }
            
            finalValue += " kiloohms";
            
        } else {
            finalValue = value;
            finalValue += " ohms";
        }

        return finalValue;
    }
}
