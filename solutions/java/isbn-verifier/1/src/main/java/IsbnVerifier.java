class IsbnVerifier {

    boolean isValid(String stringToVerify) {

        String s = stringToVerify.replace("-", "");

        if(s.length() != 10) {
            return false;
        }
        
        int[] number = new int[s.length()];

        for(int i = 0; i < s.length(); i++) {
            
            char c = s.charAt(i);
            
            if(Character.isDigit(c)) {
                
                number[i] = Integer.parseInt(String.valueOf(c));
                
            } else if(i == s.length() - 1) {
                
                if(c == 'X') {
                    number[i] = 10;
                } else {
                    return false;
                }
                
            } else {
                return false;
            }
        }

        return (number[0] * 10 + number[1] * 9 + number[2] * 8 + number[3] * 7 + number[4] * 6 + number[5] * 5 + number[6] * 4 + number[7] * 3 + number[8] * 2 + number[9] * 1) % 11 == 0;
    }

}
