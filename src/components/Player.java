package components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by AKrzos on 2016-08-23.
 */
public class Player {
    private String name;
    private boolean startingPlayer;
    private boolean usedProfHelpThisTurn;
    private int badges;
    private int profHelpTokens;
    private List<Potion> finishedPotions;
    private List<Ingredient> storage;
    private List<Ingredient> marblesInHand;
    private Potion brewedPotion1; //todo maybe list?
    private Potion brewedPotion2;
    //todo player number?

    public Player(String name) {
        this.name = name;
        startingPlayer = false;
        usedProfHelpThisTurn = false;
        badges = 0;
        profHelpTokens = 0;
        finishedPotions = new ArrayList<>();
        storage = new ArrayList<>();
        marblesInHand = new ArrayList<>();
        brewedPotion1 = null;
        brewedPotion2 = null;
    }

    public int countBadgesQualified() {
        Map<PotionType, Integer> potionCount = countPotions(finishedPotions);
        return countBadgesQualifiedDiffirent() + countBadgesQualifiedTheSame();
    }

    private Map<PotionType, Integer> countPotions(List<Potion> finishedPotions) {
        Map<PotionType, Integer> potionCountMap = new HashMap<>();
        for (Potion finishedPotion : finishedPotions) {
            if (!potionCountMap.containsKey(finishedPotion.getType())) {
                potionCountMap.put(finishedPotion.getType(), 1);
            } else {
                potionCountMap.put(finishedPotion.getType(), potionCountMap.get(finishedPotion.getType())+1);
            }
        }
        return potionCountMap;
    }

    private int countBadgesQualifiedTheSame() {
        //3
        if (finishedPotions.size() < 3) {
            return 0;
        }
        //todo - this is slow. It should be done with map
        int counter = 0;
        for (PotionType potionType : PotionType.values()) {
            int repeatedCounter = 0;
            for (Potion finishedPotion : finishedPotions) {
                if (finishedPotion.getType().equals(potionType)) {
                    repeatedCounter++;
                }
            }
            counter += repeatedCounter / 3;
        }
        return counter;
    }

    private int countBadgesQualifiedDiffirent() {
        //5
        if (finishedPotions.size() < 5) {
            return 0;
        }
        //todo
        return 0;
    }


    public int countPlayerPoints() {
        int potionPoints = 0;
        for (Potion finishedPotion : finishedPotions) {
            potionPoints += finishedPotion.getScorePoints();
        }
        return (-2) * profHelpTokens + 4 * badges + potionPoints;
    }

}
