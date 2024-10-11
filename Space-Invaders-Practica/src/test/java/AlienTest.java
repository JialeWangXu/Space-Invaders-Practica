import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import space_invaders.sprites.Alien;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlienTest {

    private Alien alien;

    @BeforeEach
    public void setUp(){
        alien = new Alien(100,100);
    }

    @Test
    public void initAlien(){
        //TRUE
        assertEquals(alien.getX(),100);
        assertEquals(alien.getY(),100);
        System.out.println("Case 1 Nominal:"+alien.getX());
        System.out.println("Case 1 Nominal:"+alien.getY());

        // Apartir de aqui ya falla
        alien.setX(-1);
        assertEquals(0,alien.getX());
        assertEquals(alien.getY(),100);
        System.out.println("Case 2 "+alien.getX());
        System.out.println("Case 2 "+alien.getY());

        alien.setX(400);
        assertEquals(358,alien.getX());
        assertEquals(alien.getY(),100);
        System.out.println("Case 3 "+alien.getX());
        System.out.println("Case 3 "+alien.getY());

        alien.setX(100);
        alien.setY(-1);
        assertEquals(100,alien.getX());
        assertEquals(0,alien.getY());
        System.out.println("Case 4 "+alien.getX());
        System.out.println("Case 4 "+alien.getY());

        alien.setY(400);
        assertEquals(100,alien.getX());
        assertEquals(350,alien.getY());
        System.out.println("Case 5 "+alien.getX());
        System.out.println("Case 5 "+alien.getY());

    }

}
