class NaturalNumber {

    private Classification classification;
    
    NaturalNumber(int number) throws IllegalArgumentException {

        if(!isPositive(number)) {
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

    private boolean isPositive(int number) {
        return number > 0;
    }

    Classification getClassification() {
        return classification;
    }
}
