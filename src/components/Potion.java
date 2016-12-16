package components;

/**
 * Created by AKrzos on 2016-08-23.
 */
public class Potion {
    private int scorePoints;
    private PotionType type;
    private boolean alreadyUsed;
    private boolean finished; //not sure if this is needed todo

    public int getScorePoints() {
        return scorePoints;
    }

    public void setScorePoints(int scorePoints) {
        this.scorePoints = scorePoints;
    }

    public PotionType getType() {
        return type;
    }

    public void setType(PotionType type) {
        this.type = type;
    }

    public boolean isAlreadyUsed() {
        return alreadyUsed;
    }

    public void setAlreadyUsed(boolean alreadyUsed) {
        this.alreadyUsed = alreadyUsed;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

// list of slots
    // type/effect
    //state

}
