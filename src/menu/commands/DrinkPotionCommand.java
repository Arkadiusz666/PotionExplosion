package menu.commands;

import components.Dispenser;

/**
 * Created by Arkadiusz666 on 2016-10-23.
 */
public class DrinkPotionCommand implements Command {
    @Override
    public void runCommand(Dispenser dispenser) {

    }

    @Override
    public void showDescription() {
        System.out.println("Drink a Potion");
    }
}
