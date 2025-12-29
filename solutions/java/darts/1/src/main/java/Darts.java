class Darts {
    int score(double xOfDart, double yOfDart) {
        
        int points = 0;
        double cA = xOfDart * xOfDart;
        double cB = yOfDart * yOfDart;
        double h  = Math.sqrt(cA + cB); 
        
        if(h > 10.0) {
            points = 0;
        } else if(h <= 10 && h > 5) {
            points = 1;
        } else if(h <= 5 && h > 1) {
            points = 5;
        } else {
            points = 10;
        }
            
        return points;
    }
}
