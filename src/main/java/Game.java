import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private ArrayList<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public int round(String playerName1, String playerName2) {
        boolean isRegistered1 = false;
        boolean isRegistered2 = false;
        int strength1 = 0;
        int strength2 = 0;
        int result = -1;
        for (Player player : players) {
            if (player.getName().equals(playerName1)) {
                isRegistered1 = true;
                strength1 = player.getStrength();
            } else if (player.getName().equals(playerName2)) {
                isRegistered2 = true;
                strength2 = player.getStrength();
            }
        }
        if (isRegistered1 && isRegistered2) {
            if (strength1 > strength2) {
                result = 1;
            } else if (strength1 < strength2) {
                result = 2;
            } else {
                result = 0;
            }
        } else {
            throw new NotRegisteredException("Игрок(и) не зарегистрирован(ы)");
        }
        return result;
    }
}
