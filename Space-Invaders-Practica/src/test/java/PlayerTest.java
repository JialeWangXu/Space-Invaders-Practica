import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import space_invaders.sprites.Alien;
import space_invaders.sprites.Player;

import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

    private Player player;
    @BeforeEach
    public void setUp(){

        player = new Player();
    }

    @Test
    public void keyPressed() {
        //hemos cogido el valor x porque no podemos comprobar con dx
        player.keyPressed(new KeyEvent(new java.awt.Label(),KeyEvent.KEY_PRESSED,System.currentTimeMillis(),0,KeyEvent.VK_UP,KeyEvent.CHAR_UNDEFINED));
        player.act();
        assertEquals(270,player.getX());
        System.out.println("Case 1 :"+player.getX());

        player.keyPressed(new KeyEvent(new java.awt.Label(),KeyEvent.KEY_PRESSED,System.currentTimeMillis(),0,KeyEvent.VK_LEFT,KeyEvent.CHAR_UNDEFINED));
        player.act();
        assertEquals(268,player.getX());
        System.out.println("Case 2 Nominal:"+player.getX());

        player.keyPressed(new KeyEvent(new java.awt.Label(),KeyEvent.KEY_PRESSED,System.currentTimeMillis(),0,KeyEvent.VK_RIGHT,KeyEvent.CHAR_UNDEFINED));
        player.act();
        assertEquals(272,player.getX());
        System.out.println("Case 3 Nominal:"+player.getX());

    }

    //en este test no lo sabemos como testear
    @Test
    public void keyReleased() {
        player.keyReleased(new KeyEvent(new java.awt.Label(),KeyEvent.KEY_PRESSED,System.currentTimeMillis(),0,KeyEvent.VK_UP,KeyEvent.CHAR_UNDEFINED));
        player.act();
        assertEquals(270,player.getX());
        System.out.println("Case 1 :"+player.getX());

        player.keyReleased(new KeyEvent(new java.awt.Label(),KeyEvent.KEY_PRESSED,System.currentTimeMillis(),0,KeyEvent.VK_RIGHT,KeyEvent.CHAR_UNDEFINED));
        player.act();
        assertEquals(270,player.getX());
        System.out.println("Case 2 Nominal:"+player.getX());


        player.keyReleased(new KeyEvent(new java.awt.Label(),KeyEvent.KEY_PRESSED,System.currentTimeMillis(),0,KeyEvent.VK_LEFT,KeyEvent.CHAR_UNDEFINED));
        player.act();
        assertEquals(270,player.getX());
        System.out.println("Case 3 Nominal:"+player.getX());
    }

    @Test
    public void act() {
        player.act();
        assertEquals(270,player.getX());
        System.out.println("Case 1 Nominal:"+player.getX());

        player.setX(0);
        player.act();
        assertEquals(15,player.getX());
        System.out.println("Case 2 :"+player.getX());


        player.setX(370);
        player.act();
        assertEquals(343,player.getX());
        System.out.println("Case 3:"+player.getX());




    }
}
