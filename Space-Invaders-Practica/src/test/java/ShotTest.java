import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import space_invaders.sprites.Shot;

import static org.junit.jupiter.api.Assertions.*;

public class ShotTest {

    private Shot shot;

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void initShot() {

        shot = new Shot(180,280);
        assertTrue(shot.getX() == 180 + 6 && shot.getY() == 280-1,
                "Caso 1: \nsalida esperada de X: 186 Y:279 \nsalida final: X: " + shot.getX() + " Y: " + shot.getY());
        System.out.println("Caso 1: \nsalida esperada de X: 186 Y:279 \nsalida final: X: " + shot.getX() + " Y: " + shot.getY());
        

    }

}
