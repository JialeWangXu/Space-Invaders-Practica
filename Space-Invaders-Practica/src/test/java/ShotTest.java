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

        shot = new Shot(353,175);
        verificarValores(358,shot.getX(),174,shot.getY(), "caso 1");


        shot = new Shot(352,175);
        verificarValores(358,shot.getX(),174,shot.getY(), "caso 2");


        shot = new Shot(351,175);
        verificarValores(356,shot.getX(),174,shot.getY(), "caso 3");


        shot = new Shot(-5,175);
        verificarValores(1,shot.getX(),174,shot.getY(), "caso 4");


        shot = new Shot(-6,175);
        verificarValores(0,shot.getX(),174,shot.getY(), "caso 5");


        shot = new Shot(-7,175);
        verificarValores(0,shot.getX(),174,shot.getY(), "caso 6");


        shot = new Shot(175,352);
        verificarValores(181,shot.getX(),350,shot.getY(), "caso 7");


        shot = new Shot(175,351);
        verificarValores(181,shot.getX(),350,shot.getY(), "caso 8");


        shot = new Shot(175,350);
        verificarValores(181,shot.getX(),349,shot.getY(), "caso 9");


        shot = new Shot(175,2);
        verificarValores(181,shot.getX(),1,shot.getY(), "caso 10");


        shot = new Shot(175,1);
        verificarValores(181,shot.getX(),0,shot.getY(), "caso 11");


        shot = new Shot(175,0);
        verificarValores(181,shot.getX(),0,shot.getY(), "caso 12");


        shot = new Shot(175,175);
        verificarValores(181,shot.getX(),174,shot.getY(), "caso 13");

    }


    private void verificarValores(int esperadoX, int codigoX, int esperadoY, int codigoY, String numeroCaso) {


        assertAll("Prueba de valor límite al método initshot",
                () -> {
                    assertEquals(esperadoX, codigoX, numeroCaso + ": \nsalida esperada de x :" + esperadoX + "  salida código de x: " + codigoX);

                },() ->{
                    assertEquals(esperadoY, codigoY, numeroCaso + ": \nsalida esperada de y :" + esperadoY + "  salida código de Y: " + codigoY);
                }

                );


    }
}
