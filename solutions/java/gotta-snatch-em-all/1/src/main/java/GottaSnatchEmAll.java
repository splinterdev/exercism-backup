import java.util.List;
import java.util.Set;
import java.util.HashSet;

class GottaSnatchEmAll {

    static Set<String> newCollection(List<String> cards) {
        if(cards.isEmpty()) {
            return new HashSet<>();
        }
        Set<String> collection = new HashSet<>();
        cards.forEach(c -> collection.add(c));
        return collection;
    }

    static boolean addCard(String card, Set<String> collection) {
        return collection.contains(card) ? false : collection.add(card);
    }

    static boolean canTrade(Set<String> myCollection, Set<String> theirCollection) {
        boolean tradable = false;
        if(myCollection.isEmpty() || theirCollection.isEmpty()) {
            tradable = false;
        }
        if(myCollection.containsAll(theirCollection) || theirCollection.containsAll(myCollection)) {
            tradable = false;
        } else if(!myCollection.containsAll(theirCollection)) {
            tradable = true;
        }
        return tradable;
    }

    static Set<String> commonCards(List<Set<String>> collections) {
        
        HashSet<String> common = new HashSet<>();
        HashSet<String> element = new HashSet<>();
        int iterations = 0;
        
        for(Set<String> set : collections) {
            
            if(collections.size() == 1) {
                return set;
            }

            element = new HashSet<>(set);
            
            if(iterations == 0) {
                common = element;
            } else {
               common.retainAll(element);
            }
            iterations++;
        }

        return common;
    }

    static Set<String> allCards(List<Set<String>> collections) {
        
        HashSet<String> allCards = new HashSet<>();
        
        for(Set<String> set : collections) {

            if(collections.size() == 1) {
                return set;
            }
            
            allCards.addAll(new HashSet<>(set));
        }

        return allCards;
    }
}
