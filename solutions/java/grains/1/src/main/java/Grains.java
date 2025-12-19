import java.math.BigInteger;
import java.lang.Math;

class Grains {

    BigInteger grainsOnSquare(final int square) throws IllegalArgumentException {

        if(square > 64 || square <= 0) {
            
            throw new IllegalArgumentException("square must be between 1 and 64");
            
        } else if(square == 1) {
            
            return BigInteger.valueOf(1);
        }

        BigInteger prev = BigInteger.ONE;
        BigInteger grainsInIndex = BigInteger.ZERO;

        for(int i = 2; i <= square; i++) {
            
            grainsInIndex = prev.multiply(BigInteger.valueOf(2));
            
            prev = grainsInIndex;
        }
        
        return grainsInIndex;
    }

    BigInteger grainsOnBoard() {
        
        BigInteger prev = BigInteger.ONE;
        BigInteger totalGrains = BigInteger.ONE;
        

        for(int i = 1; i < 64; i++) {
            
            prev = prev.multiply(BigInteger.valueOf(2));
            totalGrains = totalGrains.add(prev);
        }

        return totalGrains;
    }

}
