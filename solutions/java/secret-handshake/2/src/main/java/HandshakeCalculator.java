import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class HandshakeCalculator {

    List<Signal> calculateHandshake(int number) {

        List<Signal> signals = new ArrayList<>();

        String binary = Integer.toBinaryString(number);
        
        if(binary.length() > 5) {
            String rightMostFiveBits = binary.substring(binary.length() - 5, binary.length());
            addSignals(rightMostFiveBits.length(), signals, rightMostFiveBits);
            
        } else {
            addSignals(binary.length(), signals, binary);
        }

        return signals;
    }

    private void addSignals(int length, List<Signal> signals, String binary) {

        int lastIndex = length - 1;

        for(int i = lastIndex; i >= 0; i--) {
            
            char c = binary.charAt(i);
            
            if(c == '1') {
                switch(lastIndex - i) {
                    case 0:
                        signals.add(Signal.WINK);
                        break;
                    case 1:
                        signals.add(Signal.DOUBLE_BLINK);
                        break;
                    case 2:
                        signals.add(Signal.CLOSE_YOUR_EYES);
                        break;
                    case 3:
                        signals.add(Signal.JUMP);
                        break;
                    case 4:
                        Collections.reverse(signals);
                        break;
                }
            } 
        }
    }
}
