import java.util.Map;
import java.util.HashMap;
import java.util.Optional;

public class DialingCodes {

    private final Map<Integer, String> codes = new HashMap<>();

    public Map<Integer, String> getCodes() {
        return codes;
    }

    public void setDialingCode(Integer code, String country) {
        codes.put(code, country);
    }

    public String getCountry(Integer code) {
        return codes.get(code);
    }

    public void addNewDialingCode(Integer code, String country) {
        if(!codes.containsKey(code) && !codes.containsValue(country)) {
            codes.put(code, country);
        }
    }

    public Integer findDialingCode(String country) {
        return codes.entrySet().stream().filter(e -> e.getValue().equals(country)).map(Map.Entry::getKey).findFirst().orElse(null);
    }

    public void updateCountryDialingCode(Integer newCode, String country) {
        Integer countryCode = findDialingCode(country);
        if(countryCode != null) {
            codes.remove(countryCode);
            setDialingCode(newCode, country);
        }
     }
}
