public class GameMaster {

    public static String describe(Character character) {
        return "You're a level " + character.getLevel() + " " + character.getCharacterClass() + " with " + character.getHitPoints() + " hit points.";
    }

    public static String describe(Destination destination) {
        return "You've arrived at " + destination.getName() + ", which has " + destination.getInhabitants() + " inhabitants.";
    }
    
    public static String describe(TravelMethod travelMethod) {
        String preposition = travelMethod == travelMethod.WALKING ? " by " : " on ";
        return "You're traveling to your destination" + preposition + travelMethod.toString().toLowerCase() + ".";
    }

    public static String describe(Character character, Destination destination, TravelMethod travelMethod) {
        return GameMaster.describe(character) + " " + GameMaster.describe(travelMethod) + " " + GameMaster.describe(destination);
    }

    public static String describe(Character character, Destination destination) {
        return  GameMaster.describe(character) + " " + GameMaster.describe(TravelMethod.WALKING) + " " + GameMaster.describe(destination);
    }
}
