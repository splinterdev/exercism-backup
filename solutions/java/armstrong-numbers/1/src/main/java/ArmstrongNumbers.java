class ArmstrongNumbers {

    boolean isArmstrongNumber(int numberToCheck) {

        String chars = Integer.toString(numberToCheck);
        int[] numbers = new int[chars.length()];
        int result = 0;

        for(int i = 0; i < chars.length(); i++) {
            numbers[i] = Integer.parseInt(String.valueOf(chars.charAt(i)));
        }

        for(int i = 0; i < numbers.length; i++) {
            result += Math.pow(numbers[i], numbers.length);
        }

        return result == numberToCheck;
    }

}
