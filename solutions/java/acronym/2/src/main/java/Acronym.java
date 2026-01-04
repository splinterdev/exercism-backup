class Acronym {

    private String acronym;

    Acronym(String phrase) {
        
        StringBuilder sb = new StringBuilder();
        
        String[] fields = phrase.toUpperCase()
            .replace("-", " ")
            .replaceAll("\\s+", " ") 
            .replace("_", "")
            .split(" ");
        
        for(int i = 0; i < fields.length; i++) {
            sb.append(fields[i].charAt(0));
        }

        this.acronym = sb.toString();
    }

    public String get() {
        return acronym;
    }

}
