#include "grains.h"

uint64_t square(uint8_t index) {

    if(index > 64 || index == 0) {
        return 0;
    } else if(index == 1) {
        return 1;
    }
    
    uint64_t prev = 1;
    uint64_t grainsInIndex = 0;
    
    for(uint8_t i = 2; i <= index; i++) {
        grainsInIndex = prev * 2; 
        prev = grainsInIndex;
    }

    return grainsInIndex;
}

uint64_t total(void) {

    uint64_t prev = 1;
    uint64_t totalGrains = 1;
    
    for(uint8_t i = 1; i < 64; i++) {

        prev *= 2;
        totalGrains += prev;
    }

    return totalGrains;
}
