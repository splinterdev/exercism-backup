class CollatzCalculator {

    int computeStepCount(int start) throws IllegalArgumentException {
        
        if(start < 1) {
            throw new IllegalArgumentException("Only positive integers are allowed");
        }
 
        int steps = 0;

        while(start != 1) {
            if(start % 2 == 0) {
                start /= 2;
            } else {
                start *= 3;
                start++; 
            }
            steps++;
        }

        return steps;
    }
}
