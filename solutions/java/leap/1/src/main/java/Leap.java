class Leap {

    boolean isLeapYear(int year) {

        boolean isCentenary = year % 100 == 0 ? true : false;
        
        if(isCentenary) {
            return year % 400 == 0 ? true : false;
        }

        return year % 4 == 0 ? true : false;
    }
}
