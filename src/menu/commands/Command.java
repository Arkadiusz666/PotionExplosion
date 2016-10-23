package menu.commands;

import components.Dispenser;

/**
 * Created by Arkadiusz666 on 2016-10-23.
 */
public interface Command {
    public void runCommand(Dispenser dispenser);

    public void showDescription();

}
