import java.util.Map;
import java.util.HashMap;

public class Say {
    
    private Map<Integer, String> prefix = new HashMap<>(
        Map.of(
                1, "one",
                2, "tw",
                3, "th",
                4, "fo",
                5, "fi",
                6, "six",
                7, "seven",
                8, "eight",
                9, "nine",
                10, "ten"
        )
);
    
    public String say(long number) {

        if(number == 0) {
            return "zero";
        }
        
        if(number > 999_999_999_999L || number < 0) {
            throw new IllegalArgumentException();
        }
        
        StringBuilder sb = new StringBuilder();

        DigitType type = typeOf(number);
        
        numberName(number, type, sb); 
        
        return sb.toString();
    }

    private DigitType typeOf(long number) {
   
        if(number > 999 && number < 1_000_000) {
            return DigitType.THOUSANDS;
        } 
        
        if(number > 999_999 && number < 1_000_000_000) {
            return DigitType.MILION;
        }
        
        if(number > 999_999_999 && number < 1_000_000_000_000L) {
            return DigitType.BILION;
        }
        
        return number < 11 ? DigitType.UNITS : number < 20 ? DigitType.TEENS : number < 100 ? DigitType.TENS : DigitType.HUNDREDS;
    }

    private void numberName(long number, DigitType type, StringBuilder sb) {

        int intNumber = (int) number;

        switch(type) {

            case DigitType.UNITS:
                getUnitName(intNumber, sb);
                break;
                
            case DigitType.TEENS:
                getTeensName(intNumber, sb);
                break;

            case DigitType.TENS:
                getTensName(intNumber, sb);
                break;
                
            case DigitType.HUNDREDS:
                getHundredsName(intNumber, sb);
                break;
                
            case DigitType.THOUSANDS:
                getThousandsName(intNumber, sb);
                break;
                
            case DigitType.MILION:
                getMillionName(intNumber, sb);
                break;
                
            case DigitType.BILION:
                getBillionName(number, sb);
                break;
        }
    }

    private void getUnitName(int number, StringBuilder sb) {

        DigitType type = DigitType.UNITS;
        
        sb.append(prefix.get(number));
        
        if(number > 1 && number < 6) {
            sb.append(type.getSuffix(number));
        }
    }

    private void getTeensName(int number, StringBuilder sb) {

        DigitType type = DigitType.TEENS; 
        
        if(number == 11) {
            sb.append(type.getSuffix(number));
            
        } else {
            
            if(number < 16 || number == 18) {
                sb.append(prefix.get(number - 10)).append(type.getSuffix(number));
                
            } else {
                sb.append(prefix.get(number)).append(type.getSuffix(0));
            }
        } 
    }

    private void getTensName(int number, StringBuilder sb) {

        DigitType type = DigitType.TENS;
        String[] units = String.valueOf(number).split("");
        int firstUnit = Integer.parseInt(units[0]);
        int secondUnit = Integer.parseInt(units[1]);
        
        if(secondUnit == 0) {
            if(number < 60 || number == 80) {
                sb.append(prefix.get(firstUnit)).append(type.getSuffix(firstUnit));
                
            } else {    
                sb.append(prefix.get(firstUnit)).append(type.getSuffix(0));
            }
            
        } else {
            if(number < 60 || number >= 80 && number < 90) {
                sb.append(prefix.get(firstUnit))
                    .append(type.getSuffix(firstUnit))
                    .append("-");
                        
                getUnitName(secondUnit, sb);
                
            } else {
                sb.append(prefix.get(firstUnit))
                    .append(type.getSuffix(0))
                    .append("-");
                        
                getUnitName(secondUnit, sb);
            }
        }
    }

    private void getHundredsName(int number, StringBuilder sb) {
        
        String[] units = String.valueOf(number).split("");
        int firstUnit = Integer.parseInt(units[0]);
        int remainingUnits = 0;
        
        if(units.length == 3) {
            remainingUnits = Integer.parseInt(units[1] + units[2]);
        }
        
        getUnitName(firstUnit, sb);
        sb.append(" hundred");

        if(remainingUnits > 9) {
            sb.append(" ");
            getTensName(remainingUnits, sb);
            
        } else if(remainingUnits > 0) {
            sb.append(" ");
            getUnitName(remainingUnits, sb);
        }
    }

    private void getThousandsName(int number, StringBuilder sb) {

        String stringNumber = String.valueOf(number);
        
        if(number > 9_999 && number < 100_000) {
            int tens = Integer.parseInt(stringNumber.substring(0, 2));
            int hundred = Integer.parseInt(stringNumber.substring(2, stringNumber.length()));

            getTensName(tens, sb);
            sb.append(" thousand ");
            getHundredsName(hundred, sb);
            
        } if(number > 99_999 && number < 1_000_000) {
            int firstHundred = Integer.parseInt(stringNumber.substring(0, 3));
            int secondHundred = Integer.parseInt(stringNumber.substring(3, 6));

            getHundredsName(firstHundred, sb);
            sb.append(" thousand");

            if(secondHundred != 0) {
                sb.append(" ");
                getHundredsName(secondHundred, sb);
            }
            
        } else {            
            int firstUnit = Integer.parseInt(stringNumber.substring(0, 1));
            int hundred = Integer.parseInt(stringNumber.substring(1, stringNumber.length()));

            System.out.println("hundred caso unidade dentro de getThousand: " + hundred);
            
            getUnitName(firstUnit, sb);
            sb.append(" thousand");
            
            if(hundred != 0) {
                sb.append(" ");
                getHundredsName(hundred, sb);
            }
        }    
    }

    private void getMillionName(int number, StringBuilder sb) {
        
        String stringNumber = String.valueOf(number);
        String thousand = new String();

        if(number > 99_999_999 && number < 1_000_000_000) {
            int hundred = Integer.parseInt(stringNumber.substring(0, 3));
            getHundredsName(hundred, sb);
            sb.append(" million");
            
            thousand = stringNumber.substring(3, stringNumber.length());

        } else {
            int firstUnit = Integer.parseInt(stringNumber.substring(0, 1));
            thousand = stringNumber.substring(1, stringNumber.length());
            
            getUnitName(firstUnit, sb);
            sb.append(" million");
        }

        if(!stringNumber.substring(1, 4).equals("000")) {
            sb.append(" ");
            getThousandsName(Integer.parseInt(thousand), sb);
            
        } else if(!stringNumber.substring(4, stringNumber.length()).equals("000")) {
            sb.append(" ");
            getThousandsName(Integer.parseInt(stringNumber.substring(4, stringNumber.length())), sb);
            
        }
    }

    private void getBillionName(long number, StringBuilder sb) {
        
        String stringNumber = String.valueOf(number);
        int firstHundred = Integer.parseInt(stringNumber.substring(1, 4));
        int secondHundred = Integer.parseInt(stringNumber.substring(4, 7));
        int thirdHundred = Integer.parseInt(stringNumber.substring(7, 10));

        if(number > 999_999_999 && number < 10_000_000_000L) {
            int firstUnit = Integer.parseInt(stringNumber.substring(0, 1));
            
            getUnitName(firstUnit, sb);
            sb.append(" billion");

        
        } else if(number > 99_999_999_999L && number < 1_000_000_000_000L) { 
            String hundred = stringNumber.substring(0, 3);
            
            getHundredsName(Integer.parseInt(hundred), sb);
            sb.append(" billion");
        }

        if(firstHundred != 0) {
            sb.append(" ");
            int million = Integer.parseInt(stringNumber.substring(3, stringNumber.length()));
            getMillionName(million, sb);
            
        } else if(secondHundred != 0) {
            sb.append(" ");
            String thousand = String.valueOf(secondHundred);
            thousand += String.valueOf(thirdHundred);
            getThousandsName(Integer.parseInt(thousand), sb);
            
        } else if(thirdHundred != 0) {
            sb.append(" ");    
            getHundredsName(thirdHundred, sb);
        }
    }
}

enum DigitType {
    UNITS(Map.of(
        2, "o",
        3, "ree",
        4, "ur",
        5, "ve"
    )), 
    TEENS(Map.of(
        11, "eleven",
        12, "elve",
        13, "irteen",
        14, "urteen",
        15, "fteen",
        18, "een",
        0, "teen"
    )),
    TENS(Map.of(
        2, "enty",
        3, "irty",
        4, "rty",
        5, "fty",
        8, "y",
        0, "ty"
    )),
    HUNDREDS,
    THOUSANDS,
    MILION,
    BILION;
    
    private Map<Integer, String> suffix;

    DigitType(Map<Integer, String> suffix) {
        this.suffix = suffix;
    }

    DigitType() {
    }

    public String getSuffix(int key) {
        return suffix.get(key);
    }
}