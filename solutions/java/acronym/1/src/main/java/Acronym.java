class Acronym {

    private String acronym;

    Acronym(String phrase) {
        
        StringBuilder sb = new StringBuilder();
        
        String[] fields = phrase.toUpperCase()
            .replace("-", " ")
            .replaceAll("\\s+", " ") // troca todos os caracteres vazios (1 ou uma sequencia) por apenas 1 caracter 
            .replace("_", "")
            .split(" ");
        
        for(int i = 0; i < fields.length; i++) {
            System.out.println(fields[i]);
            sb.append(fields[i].charAt(0));
        }

        this.acronym = sb.toString();
    }

    public String get() {
        return acronym;
    }

}
