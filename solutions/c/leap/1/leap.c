#include "leap.h"

bool leap_year(int year) {

    int isCentenary = year % 100;
    int divisibleByFourHundred = year % 400;
    int divisibleByFour = year % 4;
    
    if(isCentenary == 0) {
        return divisibleByFourHundred == 0 ? true : false;
    } else {
        return divisibleByFour == 0 ? true : false;
    }
}