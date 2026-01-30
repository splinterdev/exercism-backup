class IsbnVerifier {

    boolean isValid(String stringToVerify) {

        String s = stringToVerify.replace("-", "");

        if(s.length() != 10) {
            return false;
        }
        
        int sum = 0;
        int value = 0;

        for(int i = 0; i < 10; i++) {
            
            char c = s.charAt(i);
            
            if(Character.isDigit(c)) {
                
                value = Integer.parseInt(String.valueOf(c));
                
            } else if(i == s.length() - 1) {
                
                if(c == 'X') {
                    value = 10;
                } else {
                    return false;
                }
                
            } else {
                return false;
            }

            sum += value * (10 - i);
        }

        return sum % 11 == 0;
    }

}
