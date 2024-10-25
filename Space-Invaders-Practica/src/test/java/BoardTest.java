
import main.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import space_invaders.sprites.Alien;
import space_invaders.sprites.Player;
import space_invaders.sprites.Shot;
import space_invaders.sprites.Sprite;

import java.awt.event.KeyEvent;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class BoardTest {
    private Board board;

    @BeforeEach
    public void setUp(){board = new Board();}

    @Test
    public void gameInit(){
        board.gameInit();
        assertAll("Pruebas de valor límite del método initAlien: ",
                () -> {


                    assertEquals(150,board.getAliens().get(0).getX(),"Caso 1: \nsalida esperada de X: 150 \nsalida final: " + board.getAliens().get(0).getX());
                    assertEquals(5,board.getAliens().get(0).getY(),"Caso 1: \nsalida esperada de Y: 5 \nsalida final: " + board.getAliens().get(0).getY());
                },() -> {


                    assertEquals(168,board.getAliens().get(1).getX(),"Caso 2: \nsalida esperada de X: 168 \nsalida final: " + board.getAliens().get(1).getX());
                    assertEquals(5,board.getAliens().get(1).getY(),"Caso 2: \nsalida esperada de Y: 5 \nsalida final: " + board.getAliens().get(1).getY());
                },() -> {


                    assertEquals(186,board.getAliens().get(2).getX(),"Caso 3: \nsalida esperada de X: 186 \nsalida final: " + board.getAliens().get(2).getX());
                    assertEquals(5,board.getAliens().get(2).getY(),"Caso 3: \nsalida esperada de Y: 5 \nsalida final: " + board.getAliens().get(2).getY());
                },() -> {


                    assertEquals(222,board.getAliens().get(22).getX(),"Caso 4: \nsalida esperada de X: 222 \nsalida final: " + board.getAliens().get(22).getX());
                    assertEquals(59,board.getAliens().get(22).getY(),"Caso 4: \nsalida esperada de Y: 59 \nsalida final: " + board.getAliens().get(22).getY());
                },() -> {


                    assertEquals(240,board.getAliens().get(23).getX(),"Caso 5: \nsalida esperada de X: 240 \nsalida final: " + board.getAliens().get(23).getX());
                    assertEquals(59,board.getAliens().get(23).getY(),"Caso 5: \nsalida esperada de Y: 59 \nsalida final: " + board.getAliens().get(23).getY());
                }
        );
    }


}
