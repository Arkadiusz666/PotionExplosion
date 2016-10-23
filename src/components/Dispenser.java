package components;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by AKrzos on 2016-08-23.
 */
public class Dispenser {
    private List<List<Ingredient>> rowsList;
    private List<Ingredient> waitingIngredientPool;

    public Dispenser() {
        rowsList = new ArrayList<>();
        waitingIngredientPool = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            rowsList.add(new ArrayList<Ingredient>());
        }
        this.prepareDispenser();
    }


    public Ingredient popRandomIngredientFromWaitingPool() {
        Random random = new Random();
        int randomNumber = random.nextInt(waitingIngredientPool.size());
        Ingredient randomIngredient = waitingIngredientPool.get(randomNumber);
        waitingIngredientPool.remove(randomNumber);
        return randomIngredient;
    }

    private void prepareDispenser() {
        for (int i = 0; i < 25; i++) { //original game holds 20 of each - more used to prevent running out
            waitingIngredientPool.add(new Ingredient(Color.RED));
            waitingIngredientPool.add(new Ingredient(Color.BLACK));
            waitingIngredientPool.add(new Ingredient(Color.BLUE));
            waitingIngredientPool.add(new Ingredient(Color.YELLOW));
        }
        this.fillMissingIngredients();
    }

    public void fillMissingIngredients() {
        for (List<Ingredient> ingredientsRow : rowsList) {
            while (ingredientsRow.size() < 9) {
                ingredientsRow.add(popRandomIngredientFromWaitingPool());
            }
        }
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < rowsList.size(); i++) {
            for (Ingredient ingredient : rowsList.get(i)) {
                result += ingredient;
            }
            result += "\n";
        }
        return result;
    }

    public List<Ingredient> pickIngridient(int row, int position) {
        int currentPosition = position;
        List<Ingredient> result = new ArrayList<>();
        List<Ingredient> currentRow = rowsList.get(row);
        result.add(currentRow.remove(currentPosition)); //todo not sure if this is correct
        fillMissingIngredients();

        while (isExplosion(row, currentPosition)) {
            //get explosion color
            Color explosionColor = currentRow.get(currentPosition).getColor();
            //get all at current pos
            while (currentRow.get(currentPosition).getColor() == explosionColor) {
                result.add(currentRow.remove(currentPosition));
                fillMissingIngredients();
            }
            //get all below (decrement)
            while (currentPosition > 0 && currentRow.get(currentPosition - 1).getColor() == explosionColor) {
                currentPosition--;
                result.add(currentRow.remove(currentPosition));
                fillMissingIngredients();
            }
        }
        return result;
    }

    public boolean isExplosion(int row, int position) {
        List<Ingredient> currentRow = rowsList.get(row);
        if (position > 0 && currentRow.get(position).getColor() == currentRow.get(position - 1).getColor()) {
            System.out.println("Explosion!");
            return true;
        } else
            return false;
        //todo
        //currentPosition>0&& currentRow.get(currentPosition)==currentRow.get(currentPosition-1)
    }

    public void PrintDispenser() {
        System.out.printf("  ");

        for (int i = 0; i < 8; i++) {
            System.out.printf("  " + i + "      ");
        }
        System.out.printf("\n");
        for (int i = 0; i < 5; i++) {
            System.out.println(i+" " +rowsList.get(i));
        }

    }

}
