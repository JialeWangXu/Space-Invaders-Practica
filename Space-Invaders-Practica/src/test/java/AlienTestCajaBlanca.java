import org.junit.jupiter.api.Test;
import space_invaders.sprites.Alien;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlienTestCajaBlanca {

    private Alien alien;
    @Test
    public void initAlien(){
        assertAll("Test de caja blanca del método initAlien: ",
                () -> {
                    this.alien = new Alien(355,345);
                    assertTrue(alien.getX()==355&&alien.getY()==345, "Caso 1: \nsalida esperada : x = 355 y = 345 \nsalida final: x = " + alien.getX()+" y = "+alien.getY());
                    System.out.println("Caso 1: \nsalida esperada : x = 355 y = 345 \nsalida final: x = " + alien.getX()+" y = "+alien.getY());
                },() -> {
                    this.alien = new Alien(355,-1);
                    assertTrue(alien.getX()==0&&alien.getY()==0, "Caso 2: \nsalida esperada : x = 0 y = 0 \nsalida final: x = " + alien.getX()+" y = "+alien.getY());
                    System.out.println("Caso 2: \nsalida esperada : x = 0 y = 0 \nsalida final: x = " + alien.getX()+" y = "+alien.getY());
                },() -> {
                    this.alien = new Alien(355,355);
                    assertTrue(alien.getX()==355&&alien.getY()==355, "Caso 3: \nsalida esperada : x = 355 y = 355 \nsalida final: x = " + alien.getX()+" y = "+alien.getY());
                    System.out.println("Caso 3: \nsalida esperada : x = 355 y = 355 \nsalida final: x = " + alien.getX()+" y = "+alien.getY());
                },() -> {
                    this.alien = new Alien(-1,355);
                    assertTrue(alien.getX()==-1&&alien.getY()==355, "Caso 4: \nsalida esperada : x = -1 y = 355 \nsalida final: x = " + alien.getX()+" y = "+alien.getY());
                    System.out.println("Caso 4: \nsalida esperada : x = -1 y = 355 \nsalida final: x = " + alien.getX()+" y = "+alien.getY());
                },() -> {
                    this.alien = new Alien(360,-1);
                    assertTrue(alien.getX()==358&&alien.getY()==0, "Caso 5: \nsalida esperada : x = 360 y = -1 \nsalida final: x = " + alien.getX()+" y = "+alien.getY());
                    System.out.println("Caso 5: \nsalida esperada : x = 360 y = -1 \nsalida final: x = " + alien.getX()+" y = "+alien.getY());
                }
        );
    }
}
