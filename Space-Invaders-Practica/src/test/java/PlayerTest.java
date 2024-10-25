import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import space_invaders.sprites.Alien;
import space_invaders.sprites.Player;
import space_invaders.sprites.Sprite;

import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

    private Player player;
    @BeforeEach
    public void setUp(){

        player = new Player();
    }

    @Test
    public void keyPressed() {

        assertAll("Pruebas de clase de equivalencia del método keyPressed: ",
                () -> {
                //TRUE
                    player.keyPressed(new KeyEvent(new java.awt.Label(),KeyEvent.KEY_PRESSED,System.currentTimeMillis(),0,KeyEvent.VK_UP,KeyEvent.CHAR_UNDEFINED));
                    assertEquals(0,player.getDx());
                    System.out.println("\nCaso 1 \nsalida esperada de X: 0 \nsalida final: " + player.getDx());
                },
                () -> {

                    player.keyPressed(new KeyEvent(new java.awt.Label(),KeyEvent.KEY_PRESSED,System.currentTimeMillis(),0,KeyEvent.VK_LEFT,KeyEvent.CHAR_UNDEFINED));
                    assertEquals(-2,player.getDx(),"\nCaso 2 \nsalida esperada de X: -2 \nsalida final: " + player.getDx());
                },
                () -> {
                    player.keyPressed(new KeyEvent(new java.awt.Label(),KeyEvent.KEY_PRESSED,System.currentTimeMillis(),0,KeyEvent.VK_RIGHT,KeyEvent.CHAR_UNDEFINED));
                    assertEquals(2,player.getDx());
                    System.out.println("\nCaso 3 \nsalida esperada de X: 0 \nsalida final: " + player.getDx());
                }
        );

    }

    //en este test no lo sabemos como testear
    @Test
    public void keyReleased() {
        assertAll("Pruebas de clase de equivalencia del método keyReleased: ",
                () -> {
                    //TRUE
                    player.keyPressed(new KeyEvent(new java.awt.Label(),KeyEvent.KEY_PRESSED,System.currentTimeMillis(),0,KeyEvent.VK_UP,KeyEvent.CHAR_UNDEFINED));
                    player.keyReleased(new KeyEvent(new java.awt.Label(),KeyEvent.KEY_RELEASED,System.currentTimeMillis(),0,KeyEvent.VK_UP,KeyEvent.CHAR_UNDEFINED));
                    assertEquals(0,player.getDx());
                    System.out.println("\nCaso 1 \nsalida esperada de X: 0 \nsalida final: " + player.getDx());
                },
                () -> {

                    player.keyPressed(new KeyEvent(new java.awt.Label(),KeyEvent.KEY_PRESSED,System.currentTimeMillis(),0,KeyEvent.VK_LEFT,KeyEvent.CHAR_UNDEFINED));
                    player.keyReleased(new KeyEvent(new java.awt.Label(),KeyEvent.KEY_RELEASED,System.currentTimeMillis(),0,KeyEvent.VK_LEFT,KeyEvent.CHAR_UNDEFINED));
                    assertEquals(0,player.getDx(),"\nCaso 2 \nsalida esperada de X: 0 \nsalida final: " + player.getDx());
                    System.out.println("\nCaso 2 \nsalida esperada de X: 0 \nsalida final: " + player.getDx());
                },
                () -> {
                    player.keyPressed(new KeyEvent(new java.awt.Label(),KeyEvent.KEY_PRESSED,System.currentTimeMillis(),0,KeyEvent.VK_RIGHT,KeyEvent.CHAR_UNDEFINED));
                    player.keyReleased(new KeyEvent(new java.awt.Label(),KeyEvent.KEY_RELEASED,System.currentTimeMillis(),0,KeyEvent.VK_RIGHT,KeyEvent.CHAR_UNDEFINED));
                    assertEquals(0,player.getDx());
                    System.out.println("\nCaso 3 \nsalida esperada de X: 0 \nsalida final: " + player.getDx());
                }
        );
    }

    @Test
    public void act() {

        assertAll("Pruebas de clase de equivalencia del método keyReleased: ",
                () -> {
                    //TRUE
                    player.setX(270);
                    player.act();
                    assertEquals(270,player.getX(),"\nCaso 1 \nsalida esperada de X: 270 \nsalida final: " + player.getX());
                    System.out.println("\nCaso 1 \nsalida esperada de X: 270 \nsalida final: " + player.getX());
                },
                () -> {

                    player.setX(-1);
                    player.act();
                    assertEquals(0,player.getX(),"\nCaso 2 \nsalida esperada de X: 0 \nsalida final: " + player.getX());
                    System.out.println("\nCaso 2 \nsalida esperada de X: 0 \nsalida final: " + player.getX());
                },
                () -> {
                    player.setX(0);
                    player.act();
                    assertEquals(0,player.getX(),"\nCaso 3 \nsalida esperada de X: 0 \nsalida final: " + player.getX());
                    System.out.println("\nCaso 3 \nsalida esperada de X: 0 \nsalida final: " + player.getX());
                },
                () -> {
                    player.setX(1);
                    player.act();
                    assertEquals(1,player.getX(),"\nCaso 4 \nsalida esperada de X: 1 \nsalida final: " + player.getX());
                    System.out.println("\nCaso 4 \nsalida esperada de X: 1 \nsalida final: " + player.getX());
                },
                () -> {
                    player.setX(342);
                    player.act();
                    assertEquals(342,player.getX(),"\nCaso 5 \nsalida esperada de X: 342 \nsalida final: " + player.getX());
                    System.out.println("\nCaso 5 \nsalida esperada de X: 342 \nsalida final: " + player.getX());
                },
                () -> {
                    player.setX(343);
                    player.act();
                    assertEquals(343,player.getX(),"\nCaso 6 \nsalida esperada de X: 343 \nsalida final: " + player.getX());
                    System.out.println("\nCaso 6 \nsalida esperada de X: 343 \nsalida final: " + player.getX());
                },
                () -> {
                    player.setX(344);
                    player.act();
                    assertEquals(343,player.getX(),"\nCaso 2 \nsalida esperada de X: 343 \nsalida final: " + player.getX());
                    System.out.println("\nCaso 7 \nsalida esperada de X: 343 \nsalida final: " + player.getX());
                }

        );


    }
}
