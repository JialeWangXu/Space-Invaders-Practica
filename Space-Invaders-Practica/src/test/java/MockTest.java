import main.Board;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.*;
import org.mockito.stubbing.OngoingStubbing;
import space_invaders.sprites.Alien;
import space_invaders.sprites.Player;
import space_invaders.sprites.Shot;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;


public class MockTest {


    @Test
    public void testUpdate() {
        //para el método Player.act()
        Board board = new Board();
        board.setInGame(true);
        board.getPlayer().setDx(-2);

        //para el método update_shots()
        Shot shot = new Shot();
        shot.setX(140);
        shot.setY(5);
        board.setShot(shot);

        //para el método update_aliens()
        board.setDirection(1);
        List<Alien> aliens = new ArrayList<>();
        aliens.add(new Alien(328,5));
        board.setAliens(aliens);

        //para el método update_bomb()
        Alien.Bomb bomb =aliens.getFirst().getBomb();
        bomb.setDestroyed(false);
        bomb.setX(200);
        bomb.setY(100);

        board.update();

    }

    @Test
    public void testBomb() {
        Alien alien = new Alien();  // Crea una instancia de Alien
        alien.new Bomb(150, 5);

    }

    @Test
    public void testInitAlien() {
        Alien alien = new Alien();
        alien.initAlien(150,5);

    }

    @Test
    public void testAlien(){
        new Alien(150,5);
    }

    @Test
    public void testPlayer(){
        new Player();
    }

    @Test
    public void testGameInit(){
        Board board = new Board();
        board.gameInit();
    }


    @Test
    public void testUpdate_Alien(){
    Board board = new Board();
    board.setDirection(-1);
    List<Alien> aliens = new ArrayList<>();
    aliens.add(new Alien(150,5));
    board.update_aliens();
    }


}
