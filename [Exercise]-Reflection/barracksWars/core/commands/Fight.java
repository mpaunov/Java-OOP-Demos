package barracksWars.core.commands;

import barracksWars.interfaces.Executable;

public class Fight implements Executable {
    public Fight() {
    }

    @Override
    public String execute() {
        return "fight";
    }
}
