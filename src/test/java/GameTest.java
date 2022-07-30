import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.HashMap;

public class GameTest {
    Game game = new Game();
    Player player1 = new Player(1, "Name1", 10);
    Player player2 = new Player(2, "Name2", 20);
    Player player3 = new Player(3, "Name3", 10);

    @BeforeEach
    public void Register() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
    }

    @Test
    public void shouldRegister() {
        HashMap<String, Integer> expected = new HashMap<>();
        expected.put(player1.getName(), player1.getStrength());
        expected.put(player2.getName(), player2.getStrength());
        expected.put(player3.getName(), player3.getStrength());
        HashMap<String, Integer> actual = game.getPlayers();
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"Name1, Name2, 2", "Name2, Name1, 1", "Name1, Name3, 0"})
    public void shouldBeDrawGame(String name1, String name2, int expected) {
        int actual = game.round(name1, name2);
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"Name1, Name4", "Name4, Name1", "Name4, Name5"})
    public void shouldThrow(String name1, String name2) {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round(name1, name2);
        });
    }
}
