import java.util.List;
import java.util.ArrayList;

class ProteinTranslator {


    private final List<AminoAcid> aminoAcids = List.of(
        AminoAcid.Methionine,
        AminoAcid.Phenylalanine,
        AminoAcid.Leucine,
        AminoAcid.Serine,
        AminoAcid.Tyrosine,
        AminoAcid.Cysteine,
        AminoAcid.Tryptophan,
        AminoAcid.STOP
    );

    List<String> translate(String rnaSequence) throws IllegalArgumentException {

        List<String> translated = new ArrayList<>();

        boolean foundedStopCodon = false;
        
        for(int i = 0; i < rnaSequence.length(); i += 3) {  
            
            if(foundedStopCodon) {
                break;
            }

            String codonFromRnaSequence = new String();
            
            try {
                codonFromRnaSequence = rnaSequence.substring(i, i + 3);
                
            } catch (IndexOutOfBoundsException e) {
                throw new IllegalArgumentException("Invalid codon");
            }

            if(invalidCodon(codonFromRnaSequence)) {
                throw new IllegalArgumentException("Invalid codon");
            }

            for(AminoAcid a : aminoAcids) {
                    
                List<String> codons = a.getCodons();
                    
                if(codons.contains(codonFromRnaSequence) && a == AminoAcid.STOP) {
                    foundedStopCodon = true;
                    break;
                        
                } else if(codons.contains(codonFromRnaSequence)) {
                    translated.add(a.toString());
                }
            } 
        }
        
        return translated;
    }

    private boolean invalidCodon(String codonFromRnaSequence) {

        for(AminoAcid a : aminoAcids) {
            
            List<String> codons = a.getCodons();
            
            if(codons.contains(codonFromRnaSequence)) {
                return false;
            }
        }

        return true;
    }
}

enum AminoAcid {
    
    Methionine(List.of("AUG")),
    Phenylalanine(List.of("UUU", "UUC")),
    Leucine(List.of("UUA", "UUG")),
    Serine(List.of("UCU", "UCC", "UCA", "UCG")),
    Tyrosine(List.of("UAU", "UAC")),
    Cysteine(List.of("UGU", "UGC")),
    Tryptophan(List.of("UGG")),
    STOP(List.of("UAA", "UAG", "UGA"));

    private final List<String> codons;

    AminoAcid(List<String> codons) {
        this.codons = codons;
    }

    public List<String> getCodons() {
        return codons;
    }
}