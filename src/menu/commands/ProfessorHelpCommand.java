package menu.commands;

import components.Dispenser;

import java.util.Scanner;

/**
 * Created by Arkadiusz666 on 2016-10-23.
 */
public class ProfessorHelpCommand implements Command {
    Scanner reader = new Scanner(System.in);

    @Override
    public void runCommand(Dispenser dispenser) {
        int row, position;

        dispenser.fillMissingIngredients();
        System.out.println("Enter a row: ");
        row = reader.nextInt();
        System.out.println("Enter a position: ");
        position = reader.nextInt();
        System.out.println(dispenser.pickIngridientNoExplosion(row, position)); //todo check this

        //todo, substract points


    }

    @Override
    public void showDescription() {
        System.out.println("Seek help form the professor");
    }
}
