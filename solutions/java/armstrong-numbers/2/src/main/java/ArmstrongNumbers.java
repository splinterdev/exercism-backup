class ArmstrongNumbers {

    boolean isArmstrongNumber(int numberToCheck) {

        String stringNumber = Integer.toString(numberToCheck);
        int[] numbers = new int[stringNumber.length()];
        int result = 0;

        for(int i = 0; i < stringNumber.length(); i++) {
            numbers[i] = Integer.parseInt(String.valueOf(stringNumber.charAt(i)));
        }

        for(int i = 0; i < numbers.length; i++) {
            result += (int) Math.pow(numbers[i], numbers.length);
        }

        return result == numberToCheck;
    }

}
