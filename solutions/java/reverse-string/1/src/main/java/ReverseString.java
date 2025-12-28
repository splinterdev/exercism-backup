class ReverseString {

    String reverse(String inputString) {
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = inputString.length(); i > 0; i--) {
            sb.append(inputString.charAt(i - 1));
        }
        
        return sb.toString();
    }
  
}
