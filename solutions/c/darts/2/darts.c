#include "darts.h"

uint8_t score(coordinate_t landing_position) {
    
    uint8_t points = 0;
    
    float h = hypot(landing_position.x, landing_position.y);
  
    if(h > 10.0F) {
        points = 0;
        
    } else if(h > 5.0F) {
        points = 1;
        
    } else if(h > 1.0F) {
        points = 5;
        
    } else{
        points = 10;
    }

    return points;
}