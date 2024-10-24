import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import space_invaders.sprites.Shot;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShotTest {

    private Shot shot;

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void initShot() {
        System.out.println("caso 1:");
        shot = new Shot(353,175);
        verificarValores(358,shot.getX(),174,shot.getY());

        System.out.println("caso 2:");
        shot = new Shot(352,175);
        verificarValores(358,shot.getX(),174,shot.getY());

        System.out.println("caso 3:");
        shot = new Shot(351,175);
        verificarValores(356,shot.getX(),174,shot.getY());

        System.out.println("caso 4:");
        shot = new Shot(-5,175);
        verificarValores(1,shot.getX(),174,shot.getY());

        System.out.println("caso 5:");
        shot = new Shot(-6,175);
        verificarValores(0,shot.getX(),174,shot.getY());

        System.out.println("caso 6:");
        shot = new Shot(-7,175);
        verificarValores(0,shot.getX(),174,shot.getY());

        System.out.println("caso 7:");
        shot = new Shot(175,352);
        verificarValores(181,shot.getX(),350,shot.getY());

        System.out.println("caso 8:");
        shot = new Shot(175,351);
        verificarValores(181,shot.getX(),350,shot.getY());

        System.out.println("caso 9:");
        shot = new Shot(175,350);
        verificarValores(181,shot.getX(),349,shot.getY());

        System.out.println("caso 10:");
        shot = new Shot(175,2);
        verificarValores(181,shot.getX(),1,shot.getY());

        System.out.println("caso 11:");
        shot = new Shot(175,1);
        verificarValores(181,shot.getX(),0,shot.getY());

        System.out.println("caso 12:");
        shot = new Shot(175,0);
        verificarValores(181,shot.getX(),0,shot.getY());

        System.out.println("caso 13:");
        shot = new Shot(175,175);
        verificarValores(181,shot.getX(),174,shot.getY());

    }


    private void verificarValores(int esperadoX, int realX, int esperadoY, int realY) {
        boolean Xigual= true;
        boolean Yigual= true;

        try {
            assertEquals(esperadoX, realX, "Los valores X no son iguales");
        } catch (AssertionError e) {
            Xigual = false;
        }

        try {
            assertEquals(esperadoY, realY, "Los valores Y no son iguales");
        } catch (AssertionError e) {
            Yigual = false;
        }

        if (!Xigual && !Yigual){
            System.out.println("Error, el valor X y Y no son iguales");
        }else if (!Xigual){
            System.out.println("Error, el valor X no son iguales");
        }else if (!Yigual){
            System.out.println("Error, el valor Y no son iguales");
        }else {
            System.out.println("Éxito, valor esperado es igual que el valor código");
        }
        System.out.println("Salida esperada de X: " + esperadoX + ", Salida código de X " + realX + ".");
        System.out.println("Salida esperada de Y: " + esperadoY + ", Salida código de Y " + realY + ".");

    }
}
