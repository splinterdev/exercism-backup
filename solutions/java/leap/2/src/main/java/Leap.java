class Leap {

    boolean isLeapYear(int year) {

        boolean isCentenary = year % 100 == 0 ? true : false;
        
        return isCentenary && year % 400 == 0 ? true : !isCentenary && year % 4 == 0 ? true : false;

    }
}
