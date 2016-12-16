package components;

import java.util.ArrayList;
import java.util.List;

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
        return countBadgesQualifiedDiffirent() + countBadgesQualifiedTheSame();
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
            counter+=repeatedCounter/3;
        }
return 0;
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
