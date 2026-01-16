class NaturalNumber {

    private Classification classification;
    
    NaturalNumber(int number) throws IllegalArgumentException {

        if(number <= 0) {
            throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        }

        int aliquotSum = 0;
        
        for(int i = 1; i < number; i++) {
            if(number % i == 0) {
                aliquotSum += i;
            }
        }

        classification = determineClassification(number, aliquotSum);
    }

    private Classification determineClassification(int number, int aliquotSum) {
        return number == aliquotSum ? Classification.PERFECT : number > aliquotSum ? Classification.DEFICIENT : Classification.ABUNDANT;
    }

    Classification getClassification() {
        return classification;
    }
}
