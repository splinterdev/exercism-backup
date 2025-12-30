class Darts {

    private static final double INNER_RING = 1.0;
    private static final double MIDDLE_RING = 5.0;
    private static final double OUTER_RING = 10.0;
    
    int score(double xOfDart, double yOfDart) {
        
        int points = 0;
        double h  = Math.hypot(xOfDart, yOfDart);

        
        
        if(h > OUTER_RING) {
            points = 0;
            
        } else if(h > MIDDLE_RING) {
            points = 1;
            
        } else if(h > INNER_RING) {
            points = 5;
            
        } else {
            points = 10;
        }
            
        return points;
    }
}
