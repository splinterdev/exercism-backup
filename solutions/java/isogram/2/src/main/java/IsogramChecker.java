class IsogramChecker {

    boolean isIsogram(String phrase) {
        
        String cleanedPhrase = phrase.replaceAll("[\\s-]+", "").toLowerCase();

        return cleanedPhrase.chars().distinct().count() == cleanedPhrase.length(); 
    }
}

