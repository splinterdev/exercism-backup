class RnaTranscription {

    String transcribe(String dnaStrand) {

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < dnaStrand.length(); i++) {
            char c = dnaStrand.charAt(i);
            if(c == 'G') {
                sb.append('C');
                
            } else if(c == 'C') {
                sb.append('G');
                
            } else if(c == 'T') {
                sb.append('A');
                
            } else if(c == 'A') {
                sb.append('U');
            }
        }
        
        return sb.toString();
    }
}
