package barracksWars.core.commands;

import barracksWars.interfaces.Executable;
import barracksWars.interfaces.Repository;

public class Report implements Executable {
    private Repository repository;

    public Report(Repository repository) {
        this.repository = repository;
    }

    public Report() {

    }

    @Override
    public String execute() {
        return repository.getStatistics();
    }
}
