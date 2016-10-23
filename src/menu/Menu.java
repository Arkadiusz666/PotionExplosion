package menu;

import components.Dispenser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Arkadiusz666 on 2016-10-23.
 */
public class Menu {
    private List<Command> commandList;
    private Dispenser dispenser;

    public Menu() {
        commandList = new ArrayList<>();
        dispenser = new Dispenser();
        commandList.add(new PickMarbleCommand());
        commandList.add(new ProfessorHelpCommand());
        commandList.add(new DrinkPotionCommand());
    }

    public void showMenu() {
        System.out.println("----------------------------------------------------------------------------------------------");
        for (int i = 0; i < commandList.size(); i++) {
            System.out.printf(i + ") ");
            commandList.get(i).showDescription();
        }
        //todo check if it makes sense
        System.out.println("9) EXIT");
    }

    public void runLoop() {
        while (true) {
            showDispenser();
            showMenu();
            checkInput();
        }
    }

    private void checkInput() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Pick a command: ");
        commandList.get(reader.nextInt()).runCommand(dispenser);

    }

    private void showDispenser() {
        dispenser.PrintDispenser();

    }


//    public void runCommand(int commandNumber) {
//
//    }
}
