import java.util.List;
import java.util.Random;
import java.util.ArrayList;

class DnDCharacter {

    private int hitPoints, constitution, constitutionModifier, strength, dexterity, intelligence, wisdom, charisma;
    
    private Random roll = new Random();

    public DnDCharacter() {
        this.strength = ability(rollDice());
        this.dexterity = ability(rollDice());
        this.constitution = ability(rollDice());
        this.intelligence = ability(rollDice());
        this.wisdom = ability(rollDice());
        this.charisma = ability(rollDice());
        this.hitPoints = 10 + modifier(constitution);
    }

    int ability(List<Integer> scores) {

        List<Integer> scoresArr = new ArrayList<>(scores);
        
        scoresArr.sort((x, y) -> x.compareTo(y));
        scoresArr.remove(0);

        int sum = 0;
        
        for(int i = 0; i < scoresArr.size(); i++) {
            sum += scoresArr.get(i);
        }

        return sum;
    }

    List<Integer> rollDice() {

        List<Integer> numbers = new ArrayList<>();
            
            for(int i = 0; i < 4; i++) {
                numbers.add(roll.nextInt(6) + 1);
            }

        return numbers;
    }

    int modifier(int input) {
        
        return (int) Math.floor((input - 10) / 2.0);
    }

    int getStrength() {
        return strength;
    }

    int getDexterity() {
        return dexterity;
    }

    int getConstitution() {
        return constitution;
    }

    int getIntelligence() {
        return intelligence;
    }

    int getWisdom() {
        return wisdom;
    }

    int getCharisma() {
        return charisma;
    }

    int getHitpoints() {
        return hitPoints;
    }
}
