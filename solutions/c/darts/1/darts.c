#include "darts.h"

uint8_t score(coordinate_t landing_position) {
    
    uint8_t points = 0;
    float xOfDart = landing_position.x;
    float yOfDart = landing_position.y;
    
    float h = sqrt((xOfDart * xOfDart) + (yOfDart * yOfDart));
  
    if(h > 10) {
        points = 0;
    } else if(h > 5) {
        points = 1;
    } else if(h > 1) {
        points = 5;
    } else{
        points = 10;
    }

    return points;
}