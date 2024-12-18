import org.junit.jupiter.api.*;
import space_invaders.sprites.Alien;

import static org.junit.jupiter.api.Assertions.*;

public class AlienTest {

    private Alien alien;

    @BeforeEach
    public void setUp(){
        alien = new Alien(150,100);
    }

    @Test
    public void initAlien(){
        alien = new Alien(100,100);
        assertTrue(alien.getX()==100&&alien.getY()==100,"Caso1: \nsalida esperada: X=100 Y=100 \nsalida final: X="+alien.getX()+" Y="+alien.getY());
        System.out.println("Caso1: \nsalida esperada: X=100 Y=100 \nsalida final: X="+alien.getX()+" Y="+alien.getY());
    }

    @Test
    public void initBomb(){
        alien.setBomb(alien.new Bomb(100, 100));
        assertTrue(alien.getBomb().getX()==100&&alien.getBomb().getY()==100,"Caso1: \nsalida esperada: X=100 Y=100 \nsalida final: X="+alien.getBomb().getX()+" Y="+alien.getBomb().getY());
        System.out.println("Caso1: \nsalida esperada: X=100 Y=100 \nsalida final: X="+alien.getBomb().getX()+" Y="+alien.getBomb().getY());
    }


    @Test
    public void act(){


        assertAll("Pruebas de clase de equivalencia del método act: ",
                () -> {
                    alien.act(1);
                    assertEquals(151,alien.getX(),"\nCaso 1 \nsalida esperada de X: 151 \nsalida final: " + alien.getX());
                    System.out.println("\nCaso 1 \nsalida esperada de X: 151 \nsalida final: " + alien.getX());
                },() -> {
                    alien.act(-1);
                    assertEquals(150,alien.getX(),"\nCaso 2 \nsalida esperada de X: 150 \nsalida final: " + alien.getX());
                    System.out.println("\nCaso 2 \nsalida esperada de X: 150 \nsalida final: " + alien.getX());
                }
        );

    }

}
