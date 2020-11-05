package team;

import shopping.StringValidator;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        setName(name);
        setEndurance(endurance);
        setSprint(sprint);
        setDribble(dribble);
        setPassing(passing);
        setShooting(shooting);
    }

    private void setName(String name) {
        if (!StringValidator.isValidName(name)) {
            throw new IllegalArgumentException("A name should not be empty.");
        }

        this.name = name;
    }

    private void setEndurance(int endurance) {
        validateStatus(endurance, "Endurance");
        this.endurance = endurance;
    }

    private void validateStatus(int val, String exceptionPrefix) {
        if (val < 0 || val > 100) {
            throw new IllegalArgumentException(exceptionPrefix + " should be between 0 and 100.");
        }
    }

    private void setSprint(int sprint) {
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        this.shooting = shooting;
    }

    public String getName() {
        return name;
    }

    public double overallSkillLevel() {
        return (endurance +
                sprint +
                dribble +
                passing +
                shooting) / 5.00;
    }
}
