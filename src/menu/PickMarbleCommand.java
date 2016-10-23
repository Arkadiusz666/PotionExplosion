package menu;

import components.Dispenser;

import java.util.Scanner;

/**
 * Created by Arkadiusz666 on 2016-10-23.
 */
public class PickMarbleCommand implements Command {
    Scanner reader;


    public PickMarbleCommand() {
        reader = new Scanner(System.in);
    }

    @Override
    public void runCommand(Dispenser dispenser) {
        int row, position;

            dispenser.fillMissingIngredients();
            System.out.println("Enter a row: ");
            row = reader.nextInt();
            System.out.println("Enter a position: ");
            position = reader.nextInt();
            System.out.println(dispenser.pickIngridient(row, position)); //todo check this
    }

    @Override
    public void showDescription() {
        System.out.println("Pick an Ingredient");

    }
}
