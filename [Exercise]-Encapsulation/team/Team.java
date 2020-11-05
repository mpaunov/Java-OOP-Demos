package team;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.name = name;
        this.players = new ArrayList<>();
    }

   public void addPlayer(Player player) {
        this.players.add(player);
   }

   public void removePlayer(String playerName) {
       boolean removed = this.players.removeIf(p -> p.getName().equals(playerName));

       if (!removed) {
           throw new IllegalArgumentException(
                   "Player " + playerName + " is not in " + name + " team.");
       }
   }

   public double getRating() {
        return this.players.stream()
                .mapToDouble(Player::overallSkillLevel)
                .sum();
   }

}
