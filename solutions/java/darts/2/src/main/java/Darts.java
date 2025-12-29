class Darts {
    int score(double xOfDart, double yOfDart) {
        
        int points = 0;
        double h  = Math.sqrt((xOfDart * xOfDart) + (yOfDart * yOfDart)); 

        
        
        if(h > 10) {
            points = 0;
            
        } else if(h > 5) {
            points = 1;
            
        } else if(h > 1) {
            points = 5;
            
        } else {
            points = 10;
        }
            
        return points;
    }
}
