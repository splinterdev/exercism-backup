class IsogramChecker {

    boolean isIsogram(String phrase) {
        
        String cleanedPhrase = phrase.replaceAll("[\\s-]+", "");
        
        for(int i = 0; i < cleanedPhrase.length(); i++) {
            
            String firstLetter = String.valueOf(cleanedPhrase.charAt(i));
            
            for(int j = i + 1; j < cleanedPhrase.length(); j++) {
                
                String secondLetter = String.valueOf(cleanedPhrase.charAt(j));
                
                if(firstLetter.equalsIgnoreCase(secondLetter)) {
                    return false;
                }
            }
        }

        return true;
    }
}

