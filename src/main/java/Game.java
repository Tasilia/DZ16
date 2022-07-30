import java.util.HashMap;

public class Game {

    private HashMap<String, Integer> players = new HashMap<>();

    public void register(Player player) {
        players.put(player.getName(), player.getStrength());
    }

    public HashMap<String, Integer> getPlayers() {
        return players;
    }

    public int round(String playerName1, String playerName2) {
        boolean isRegistered1 = false;
        boolean isRegistered2 = false;
        int strength1 = 0;
        int strength2 = 0;
        int result = -1;
        if (players.containsKey(playerName1)) {
            isRegistered1 = true;
            strength1 = players.get(playerName1);
        }
        if (players.containsKey(playerName2)) {
            isRegistered2 = true;
            strength2 = players.get(playerName2);
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
