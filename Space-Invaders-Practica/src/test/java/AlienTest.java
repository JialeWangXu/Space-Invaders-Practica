import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import space_invaders.sprites.Alien;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlienTest {

    private Alien alien;

    @BeforeEach
    public void setUp(){
        alien = new Alien(-1,100);
    }

    @Test
    public void initAlien(){

        assertAll("Pruebas de valor límite del método initAlien: ",
                () -> {
                    //FALSE
                    assertEquals(0,alien.getX(),"Caso 1: \nsalida esperada de X: 0 \nsalida final: " + alien.getX());
                },
                () -> {
                    //TRUE
                    alien.setX(0);
                    assertEquals(0,alien.getX(), "Caso 2: \nsalida esperada de X: 0 \nsalida final: " + alien.getX());
                },
                () -> {
                    //TRUE
                    alien.setX(1);
                    assertEquals(1,alien.getX(), "Caso 3: \nsalida esperada de X: 1 \nsalida final: " + alien.getX());
                },
                () -> {
                    //TRUE
                    alien.setX(100);
                    assertEquals(100,alien.getX(), "\nCaso 4: \nsalida esperada de X: 100 \nsalida final: " + alien.getX());
                },
                () -> {
                    //TRUE
                    alien.setX(357);
                    assertEquals(357,alien.getX(), "\nCaso 5: \nsalida esperada de X: 357 \nsalida final: " + alien.getX());
                },
                () -> {
                    //TRUE
                    alien.setX(358);
                    assertEquals(358,alien.getX(), "\nCaso 6: \nsalida esperada de X: 358 \nsalida final: " + alien.getX());
                },
                () -> {
                    //FALSE
                    alien.setX(359);
                    assertEquals(358,alien.getX(), "\nCaso 7: \nsalida esperada de X: 359 \nsalida final: " + alien.getX());
                },
                () -> {
                    //FALSE
                    alien.setY(-1);
                    assertEquals(0,alien.getY(), "\nCaso 8: \nsalida esperado de Y: 0 \nsalida final: " + alien.getY());
                },
                () -> {
                    //TRUE
                    alien.setY(0);
                    assertEquals(0,alien.getY(), "\nCaso 9: \nsalida esperado de Y: 0 \nsalida final: " + alien.getY());
                },
                () -> {
                    //TRUE
                    alien.setY(1);
                    assertEquals(1,alien.getY(), "\nCaso 10: \nsalida esperado de Y: 1 \nsalida final: " + alien.getY());
                },
                () -> {
                    //TRUE
                    alien.setY(349);
                    assertEquals(349,alien.getY(), "\nCaso 11: \nsalida esperado de Y: 349 \nsalida final: " + alien.getY());
                },
                () -> {
                    //TRUE
                    alien.setY(350);
                    assertEquals(350,alien.getY(), "\nCaso 12: \nsalida esperado de Y: 350 \nsalida final: " + alien.getY());
                },
                () -> {
                    //FALSE
                    alien.setY(351);
                    assertEquals(350,alien.getY(), "\nCaso 13: \nsalida esperado de Y: 350 \nsalida final: " + alien.getY());
                }
                );

    }

    @Test
    public void actTest(){
         System.out.println("Antes de valor especial: " + alien.getX());
         alien.act(2);
        System.out.println("\nDespués de valor especial: " + alien.getX());

    }

    @Test
    public void initBomb(){
        assertAll("Pruebas de valor límite del método initAlien: ",
                () -> {

                    assertEquals(0,alien.getX(),"Caso 1: \nsalida esperada de X: 0 \nsalida final: " + alien.getX());
                },
                () -> {

                    alien.setX(0);
                    assertEquals(0,alien.getX(), "Caso 2: \nsalida esperada de X: 0 \nsalida final: " + alien.getX());
                },
                () -> {
                    //TRUE
                    alien.setX(1);
                    assertEquals(1,alien.getX(), "Caso 3: \nsalida esperada de X: 1 \nsalida final: " + alien.getX());
                },
                () -> {
                    //TRUE
                    alien.setX(100);
                    assertEquals(0,alien.getX(), "\nCaso 4: \nsalida esperada de X: 100 \nsalida final: " + alien.getX());
                },
                () -> {
                    //TRUE
                    alien.setX(357);
                    assertEquals(357,alien.getX(), "\nCaso 5: \nsalida esperada de X: 357 \nsalida final: " + alien.getX());
                },
                () -> {
                    //TRUE
                    alien.setX(358);
                    assertEquals(358,alien.getX(), "\nCaso 6: \nsalida esperada de X: 358 \nsalida final: " + alien.getX());
                },
                () -> {
                    //TRUE
                    alien.setX(359);
                    assertEquals(358,alien.getX(), "\nCaso 7: \nsalida esperada de X: 359 \nsalida final: " + alien.getX());
                },
                () -> {
                    //TRUE
                    alien.setY(-1);
                    assertEquals(0,alien.getY(), "\nCaso 8: \nsalida esperado de Y: 0 \nsalida final: " + alien.getY());
                },
                () -> {
                    //TRUE
                    alien.setY(0);
                    assertEquals(0,alien.getY(), "\nCaso 9: \nsalida esperado de Y: 0 \nsalida final: " + alien.getY());
                },
                () -> {
                    //TRUE
                    alien.setY(1);
                    assertEquals(1,alien.getY(), "\nCaso 10: \nsalida esperado de Y: 1 \nsalida final: " + alien.getY());
                },
                () -> {
                    //TRUE
                    alien.setY(100);
                    assertEquals(100,alien.getY(), "\nCaso 11: \nsalida esperado de Y: 100 \nsalida final: " + alien.getY());
                },
                () -> {
                    //TRUE
                    alien.setY(349);
                    assertEquals(349,alien.getY(), "\nCaso 12: \nsalida esperado de Y: 349 \nsalida final: " + alien.getY());
                },
                () -> {
                    //TRUE
                    alien.setY(350);
                    assertEquals(350,alien.getY(), "\nCaso 13: \nsalida esperado de Y: 350 \nsalida final: " + alien.getY());
                },
                () -> {
                    //TRUE
                    alien.setY(351);
                    assertEquals(351,alien.getY(), "\nCaso 14: \nsalida esperado de Y: 350 \nsalida final: " + alien.getY());
                }
        );
    }

}
