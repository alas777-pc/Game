package ru.netology.statistic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    public void testWhenSecondPlayerWin(){
        Player koly = new Player(120, "Коля", 123);
        Player nick = new Player(157, "Ник", 100);
        Game game = new Game();

        game.register(koly);
        game.register(nick);
        int actual = game.round("Ник", "Коля");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenFirstPlayerWin(){
        Player koly = new Player(120, "Коля", 123);
        Player nick = new Player(157, "Ник", 100);
        Game game = new Game();

        game.register(koly);
        game.register(nick);
        int actual = game.round("Коля", "Ник");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenStrengthsEqual(){
        Player koly = new Player(1, "Коля", 100);
        Player nick = new Player(2, "Ник", 100);
        Game game = new Game();

        game.register(koly);
        game.register(nick);
        int actual = game.round("Коля", "Ник");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenFirstPlayerNotExist(){
        Player koly = new Player(1, "Коля", 100);
        Game game = new Game();

        game.register(koly);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Вася", "Коля")
        );
    }

    @Test
    public void testWhenSecondPlayerNotExist(){
        Player koly = new Player(1, "Коля", 100);
        Game game = new Game();

        game.register(koly);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Коля", "Вася")
        );
    }

}