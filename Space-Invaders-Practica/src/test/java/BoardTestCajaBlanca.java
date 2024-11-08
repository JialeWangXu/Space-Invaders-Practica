import main.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTestCajaBlanca {

        private Board board;

        @BeforeEach
        public void setUp(){board = new Board();}

        @Test
        public void update_alien_test(){
            board.gameInit();
            assertAll("Test de caja blanca del método update_alien: ",
                    () -> {
                        // R5
                        board.setDirection(1);
                        board.getAliens().get(8).setX(150);
                        board.getAliens().get(8).setY(5);
                        board.update_aliens();
                        assertEquals(5, board.getAliens().get(8).getY(), "Caso 1: \nsalida esperada : 5 \nsalida final: " + board.getAliens().get(8).getY());
                        System.out.println("Caso 1: \nsalida esperada : 5 \nsalida final: " + board.getAliens().get(8).getY());

                    }, () -> {
                        // R6
                        board.setDirection(1);
                        board.getAliens().get(9).setX(2);
                        board.getAliens().get(9).setY(5);
                        board.update_aliens();
                        assertEquals(5, board.getAliens().get(9).getY(), "Caso 2: \nsalida esperada : 5 \nsalida final: " + board.getAliens().get(9).getY());
                        System.out.println("Caso 2: \nsalida esperada : 5 \nsalida final: " + board.getAliens().get(9).getY());

                    }, () -> {
                        // R8
                        board.setDirection(-1);
                        board.getAliens().get(1).setX(2);
                        board.getAliens().get(1).setY(280);
                        board.update_aliens();
                        assertEquals("Invasion!", board.getMessage(), "Caso 4: \nsalida esperada : Invasion! \nsalida final: " + board.getMessage());
                        System.out.println("Caso 4: \nsalida esperada : Invasion! \nsalida final: " + board.getMessage());

                    },() -> {
                        // R9
                        board.setDirection(-1);
                        board.getAliens().get(2).setX(330);
                        board.getAliens().get(2).setY(5);
                        board.update_aliens();
                        assertEquals(5, board.getAliens().get(8).getY(), "Caso 1: \nsalida esperada : 5 \nsalida final: " + board.getAliens().get(8).getY());
                        System.out.println("Caso 5: \nsalida esperada : 5 \nsalida final: " + board.getAliens().get(8).getY());

                    }, () -> {
                        // R11
                        board.setDirection(1);
                        board.getAliens().get(1).setX(330);
                        board.getAliens().get(1).setY(280);
                        board.update_aliens();
                        assertEquals("Invasion!", board.getMessage(), "Caso 6: \nsalida esperada : Invasion! \nsalida final: " + board.getMessage());
                        System.out.println("Caso 6: \nsalida esperada : Invasion! \nsalida final: " + board.getMessage());

                    }
            );


        }


    }


