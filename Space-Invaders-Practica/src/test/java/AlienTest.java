import org.junit.jupiter.api.*;
import space_invaders.sprites.Alien;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlienTest {

    private Alien alien;

    @BeforeEach
    public void setUp(){
        alien = new Alien(150,100);
    }

    @Test
    public void initAlien(){

        assertAll("Pruebas de valor límite del método initAlien: ",
                () -> {
                    //FALSE
                    alien = new Alien(-1,100);
                    assertEquals(0,alien.getX(),"Caso 1: \nsalida esperada de X: 0 \nsalida final: " + alien.getX());
                },
                () -> {
                    //TRUE
                    alien = new Alien(0,100);
                    assertEquals(0,alien.getX(), "Caso 2: \nsalida esperada de X: 0 \nsalida final: " + alien.getX());
                },
                () -> {
                    //TRUE
                    alien = new Alien(1,100);
                    assertEquals(1,alien.getX(), "Caso 3: \nsalida esperada de X: 1 \nsalida final: " + alien.getX());
                },
                () -> {
                    //TRUE
                    alien = new Alien(100,100);
                    assertEquals(100,alien.getX(), "\nCaso 4: \nsalida esperada de X: 100 \nsalida final: " + alien.getX());
                },
                () -> {
                    //TRUE
                    alien = new Alien(357,100);
                    assertEquals(357,alien.getX(), "\nCaso 5: \nsalida esperada de X: 357 \nsalida final: " + alien.getX());
                },
                () -> {
                    //TRUE
                    alien = new Alien(358,100);
                    assertEquals(358,alien.getX(), "\nCaso 6: \nsalida esperada de X: 358 \nsalida final: " + alien.getX());
                },
                () -> {
                    //FALSE
                    alien = new Alien(359,100);
                    assertEquals(358,alien.getX(), "\nCaso 7: \nsalida esperada de X: 358 \nsalida final: " + alien.getX());
                },
                () -> {
                    //FALSE
                    alien = new Alien(100,-1);
                    assertEquals(0,alien.getY(), "\nCaso 8: \nsalida esperado de Y: 0 \nsalida final: " + alien.getY());
                },
                () -> {
                    //TRUE
                    alien = new Alien(100,0);
                    assertEquals(0,alien.getY(), "\nCaso 9: \nsalida esperado de Y: 0 \nsalida final: " + alien.getY());
                },
                () -> {
                    //TRUE
                    alien = new Alien(100,1);
                    assertEquals(1,alien.getY(), "\nCaso 10: \nsalida esperado de Y: 1 \nsalida final: " + alien.getY());
                },
                () -> {
                    //TRUE
                    alien = new Alien(100,349);
                    assertEquals(349,alien.getY(), "\nCaso 11: \nsalida esperado de Y: 349 \nsalida final: " + alien.getY());
                },
                () -> {
                    //TRUE
                    alien = new Alien(100,350);
                    assertEquals(350,alien.getY(), "\nCaso 12: \nsalida esperado de Y: 350 \nsalida final: " + alien.getY());
                },
                () -> {
                    //FALSE
                    alien = new Alien(100,351);
                    assertEquals(350,alien.getY(), "\nCaso 13: \nsalida esperado de Y: 350 \nsalida final: " + alien.getY());
                }
                );

    }

    @Test
    public void initBomb(){
        assertAll("Pruebas de valor límite del método initBomb: ",
                () -> {
                    alien.setBomb(alien.new Bomb(-1, 100));
                    assertEquals(0,alien.getBomb().getX(),"Caso 1: \nsalida esperada de X: 0 \nsalida final: " + alien.getBomb().getX());
                },
                () -> {

                    alien.setBomb(alien.new Bomb(0, 100));
                    assertEquals(0,alien.getBomb().getX(), "Caso 2: \nsalida esperada de X: 0 \nsalida final: " + alien.getBomb().getX());
                },
                () -> {
                    //TRUE
                    alien.setBomb(alien.new Bomb(1, 100));
                    assertEquals(1,alien.getBomb().getX(), "Caso 3: \nsalida esperada de X: 1 \nsalida final: " + alien.getBomb().getX());
                },
                () -> {
                    //TRUE
                    alien.setBomb(alien.new Bomb(100, 100));
                    assertEquals(100,alien.getBomb().getX(), "\nCaso 4: \nsalida esperada de X: 100 \nsalida final: " + alien.getBomb().getX());
                },
                () -> {
                    //TRUE
                    alien.setBomb(alien.new Bomb(357, 100));
                    assertEquals(357,alien.getBomb().getX(), "\nCaso 5: \nsalida esperada de X: 357 \nsalida final: " + alien.getBomb().getX());
                },
                () -> {
                    //TRUE
                    alien.setBomb(alien.new Bomb(358, 100));
                    assertEquals(358,alien.getBomb().getX(), "\nCaso 6: \nsalida esperada de X: 358 \nsalida final: " + alien.getBomb().getX());
                },
                () -> {
                    //TRUE
                    alien.setBomb(alien.new Bomb(359, 100));
                    assertEquals(358,alien.getBomb().getX(), "\nCaso 7: \nsalida esperada de X: 359 \nsalida final: " + alien.getBomb().getX());
                },
                () -> {
                    //TRUE
                    alien.setBomb(alien.new Bomb(100, -1));
                    assertEquals(0,alien.getBomb().getY(), "\nCaso 8: \nsalida esperado de Y: 0 \nsalida final: " + alien.getBomb().getY());
                },
                () -> {
                    //TRUE
                    alien.setBomb(alien.new Bomb(100, 0));
                    assertEquals(0,alien.getBomb().getY(), "\nCaso 9: \nsalida esperado de Y: 0 \nsalida final: " + alien.getBomb().getY());
                },
                () -> {
                    //TRUE
                    alien.setBomb(alien.new Bomb(100, 1));
                    assertEquals(1,alien.getBomb().getY(), "\nCaso 10: \nsalida esperado de Y: 1 \nsalida final: " + alien.getBomb().getY());
                },
                () -> {
                    //TRUE
                    alien.setBomb(alien.new Bomb(100, 349));
                    assertEquals(349,alien.getBomb().getY(), "\nCaso 11: \nsalida esperado de Y: 349 \nsalida final: " + alien.getBomb().getY());
                },
                () -> {
                    //TRUE
                    alien.setBomb(alien.new Bomb(100, 350));
                    assertEquals(350,alien.getBomb().getY(), "\nCaso 12: \nsalida esperado de Y: 350 \nsalida final: " + alien.getBomb().getY());
                },
                () -> {
                    //TRUE
                    alien.setBomb(alien.new Bomb(100, 351));
                    assertEquals(350,alien.getBomb().getY(), "\nCaso 13: \nsalida esperado de Y: 350 \nsalida final: " + alien.getBomb().getY());
                }
        );
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
