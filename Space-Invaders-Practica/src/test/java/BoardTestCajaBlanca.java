import main.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

        @Test
        public void update_bomb_test(){
            board.gameInit();
            board.getPlayer().setX(180);
            board.getPlayer().setY(280);
            assertAll("Test de caja blanca del método update_bomb: ",
                    () -> {
                        board.getAliens().get(0).getBomb().setDestroyed(true);
                        board.update_bomb();
                        assertTrue(board.getAliens().get(0).getBomb().isDestroyed(), "Caso 1: \nsalida esperada : true \nsalida final: " + board.getAliens().get(0).getBomb().isDestroyed());
                        System.out.println("Caso 1: destruir bomba \nsalida esperada : true \nsalida final: " + board.getAliens().get(0).getBomb().isDestroyed());
                    },() -> {

                        board.getAliens().get(6).getBomb().setX(180);
                        board.getAliens().get(6).getBomb().setY(280);
                        board.getAliens().get(6).getBomb().setDestroyed(false);
                        board.update_bomb();

                        assertTrue(board.getPlayer().isDying(), "Caso 2: \nsalida esperada : true \nsalida final: " + board.getPlayer().isDying());
                        System.out.println("Caso 2: player died\nsalida esperada : true \nsalida final: " + board.getPlayer().isDying());

                    }
            );
        }


    }


