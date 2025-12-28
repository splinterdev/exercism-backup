import java.util.List;
import java.util.ArrayList;

class HighScores {

    ArrayList<Integer> highScores;

    public HighScores(List<Integer> highScores) {
        this.highScores = new ArrayList<>(highScores);
    }

    List<Integer> scores() {
        return highScores;
    }

    Integer latest() {
        return highScores.getLast();
    }

    Integer personalBest() {
        ArrayList<Integer> sortedScores = new ArrayList<>(highScores);
        sortedScores.sort((s1, s2) -> s1.compareTo(s2));
        return sortedScores.get(highScores.size() - 1);
    }

    List<Integer> personalTopThree() {
        ArrayList<Integer> sortedScores = new ArrayList<>(highScores);
        ArrayList<Integer> personal = new ArrayList<>();
        sortedScores.sort((s1, s2) -> s2.compareTo(s1));
        
        if(highScores.size() >= 3) {
            for(int i = 0; i < 3; i++) {
                personal.add(sortedScores.get(i));
            }
        } else {
            for(int i = 0; i < highScores.size(); i++) {
                personal.add(sortedScores.get(i));
            }
        }
        
        return personal;
    }

}
