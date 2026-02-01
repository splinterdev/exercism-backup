import java.util.List;
import java.util.ArrayList;

class DiamondPrinter {

    List<String> printToList(char c) {

        char nextLetter = 'A';
        char input = Character.toUpperCase(c);
        int posLength = (input - nextLetter) * 2 + 1;
        
        List<String> list = new ArrayList<>();
        
        do {
            
            StringBuilder sb = new StringBuilder();

            int unicodeDiference = input - nextLetter;

            generateLine(nextLetter, unicodeDiference, posLength, sb);
            list.add(sb.toString());
                
            nextLetter += 1;
            
        } while(nextLetter <= input);

        if(nextLetter <= 'B') {
            return list;
        } else {
            nextLetter -= 2;
        }
        
        do{
            
            StringBuilder sb = new StringBuilder();

            int unicodeDiference = input - nextLetter;

            generateLine(nextLetter, unicodeDiference, posLength, sb);
            list.add(sb.toString());
            
            nextLetter -= 1;
            
        } while(nextLetter >= 'A');

        return list;
    }

    private void generateLine(char nextLetter, int unicodeDiference, int posLength, StringBuilder sb) {
        
        for(int i = 0; i < posLength; i++) {
            if(i == unicodeDiference || i == (posLength - unicodeDiference) - 1) {
                sb.append(Character.toUpperCase(nextLetter));
            } else {
                sb.append(" ");
            }
        }
    }
}
