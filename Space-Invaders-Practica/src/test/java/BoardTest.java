
import main.Board;
import main.Commons;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSources;
import space_invaders.sprites.Alien;
import space_invaders.sprites.Player;
import space_invaders.sprites.Shot;
import space_invaders.sprites.Sprite;

import java.awt.event.KeyEvent;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


public class BoardTest {
    private Board board;

    @BeforeEach
    public void setUp(){board = new Board();}

    @Test
    public void gameInit(){
        board.gameInit();

        assertAll("Pruebas de tabla de decisión del método initAlien: ",
                () -> {
                    assertFalse( board.getAliens().size() != 24,
                            "caso 1, alienígenas generado erróneamente por insuficiente numero total de alienígenas: " +
                                    "\nsalida esperada de numero de alien = distinto que 24, salida final de numero de alien: " + board.getAliens().size());

                    System.out.println("caso 1, alienígenas generado erróneamente por insuficiente numero total de alienígenas: " +
                                    "\nsalida esperada de numero de alien = distinto que 24, salida final de numero de alien: " + board.getAliens().size());

                },() -> {
                    assertFalse(board.getAliens().get(0).getX() != 150 || board.getAliens().get(0).getY() != 5,
                            "caso 2, alienígenas generado erróneamente por instanciar en la coordenada errónea: " +
                                    "\nsalida esperada de X: distinto que 150,  salida final de X: "+ board.getAliens().get(0).getX()
                                    +"\nsalida esperada de Y: distinto que 5,  salida final de Y:"+ board.getAliens().get(0).getY());

                    System.out.println("caso 2, alienígenas generado erróneamente por instanciar en la coordenada errónea: " +
                                    "\nsalida esperada de X: distinto que 150,  salida final de X: "+ board.getAliens().get(0).getX()
                                    +"\nsalida esperada de Y: distinto que 5,  salida final de Y:"+ board.getAliens().get(0).getY());

                },() -> {
                    assertTrue(board.getAliens().get(0).getX() == 150 && board.getAliens().get(0).getY() == 5 && board.getAliens().size() == 24,
                            "caso 3 alienígenas generado correctamente: \nsalida esperada de X: 150,  salida final de X: "+ board.getAliens().get(0).getX()
                                    +"\nsalida esperada de Y: 5,  salida final de Y:"+ board.getAliens().get(0).getY()
                                    +"\nsalida esperada de numero de alien = 24,  salida final de numero de alien: " + board.getAliens().size());
                    System.out.println("caso 1 : \nsalida esperada de X: 150,  salida final de X: "+ board.getAliens().get(0).getX()
                            +"\nsalida esperada de Y: 5,  salida final de Y:"+ board.getAliens().get(0).getY()
                            +"\nsalida esperada de numero de alien = distinto que 24,  salida final de numero de alien: " + board.getAliens().size());


                }
        );
    }


    @Test
    public void update(){
        board.setInGame(true);
        System.out.println(board.getDeaths());
        assertAll("Pruebas de clase de equivalencia del método update: ",
                () -> {
                    board.setDeaths(24);
                    board.update();
                    assertTrue( board.getMessage()=="Game won!" && !board.isInGame(), "Caso 1: \nsalida esperada : Game won! \nsalida final: " + board.getMessage());
                    System.out.println("Caso 1: \nsalida esperada : Game won! \nsalida final: " + board.getMessage());

                },
                ()->{
                    board.setInGame(true);
                    board.setDeaths(3);
                    board.update();
                    assertTrue( board.isInGame(), "Caso 2: \nsalida esperada : True \nsalida final: " + board.isInGame());
                    System.out.println("Caso 2: \nsalida esperada :  \nsalida final: " + board.isInGame());
                }
        );

    }

    @Test
    public void update_shots(){

        board.gameInit();
        for (int i = 1; i < board.getAliens().size(); i++) {
            board.getAliens().get(i).setDying(true);
            board.setDeaths(23);
        }
        board.getAliens().get(0).setX(150);
        board.getAliens().get(0).setY(5);

        assertAll("Pruebas de tabla de decisión del método update_shots: ",
                () -> {
                    Shot shot = new Shot();
                    shot.setX(140);
                    shot.setY(5);
                    board.setShot(shot);
                    board.update_shots();

                    assertEquals(1, board.getShot().getY(),
                            "Caso 1, Shot_Y - 4: \nsalida esperada: Y == 1   salida código: Y == " + board.getShot().getY());

                    System.out.println("Caso 1, Shot_Y - 4: \nsalida esperada: Y == 1   salida código: Y == " + board.getShot().getY());

                },
                () -> {
                    Shot shot = new Shot();
                    shot.setX(165);
                    shot.setY(5);
                    board.setShot(shot);
                    board.update_shots();

                    assertEquals(1, board.getShot().getY(),
                            "\nCaso 2, Shot_Y - 4: \nsalida esperada: Y == 1   salida código: Y == " + board.getShot().getY());

                    System.out.println("\nCaso 2, Shot_Y - 4: \nsalida esperada: Y == 1   salida código: Y == " + board.getShot().getY());

                },
                () -> {
                    Shot shot = new Shot();
                    shot.setX(150);
                    shot.setY(50);
                    board.setShot(shot);
                    board.update_shots();

                    assertEquals(46, board.getShot().getY(),
                            "\nCaso 3, Shot_Y - 4: \nsalida esperada: Y == 46   salida código: Y == " + board.getShot().getY());
                    System.out.println("\nCaso 3, Shot_Y - 4: \nsalida esperada: Y == 46   salida código: Y == " + board.getShot().getY());

                },
                () -> {
                    Shot shot = new Shot();
                    shot.setX(150);
                    shot.setY(5);
                    board.setShot(shot);
                    board.update_shots();
                    assertTrue(board.getDeaths() == 24 && board.getAliens().getFirst().isDying(),
                            "\nCaso 4, Destruir disparo por chocar con alienigeno:" +
                                    "\nsalida esperada: Death == 24  aliens[0].isDying == true" +
                                    "\nsalida de código Death == " + board.getDeaths() + " aliens[0].isDying == " + board.getAliens().getFirst().isDying());

                    System.out.println("\nCaso 4, Destruir disparo por chocar con alienigeno:" +
                                    "\nsalida esperada: Death == 24  aliens[0].isDying == true" +
                                    "\nsalida de código Death == " + board.getDeaths() + " aliens[0].isDying == " + board.getAliens().getFirst().isDying());
                },
                () -> {
                    Shot shot = new Shot();
                    shot.setX(150);
                    shot.setY(1);
                    board.setShot(shot);
                    board.update_shots();
                    assertFalse(shot.isVisible(), "\nCaso 5, Destruir disparo por chocar con suelo" +
                            "\nsalida esperada: shot.isVisible == false    salida código: shot.isVisible == " +  shot.isVisible());

                    System.out.println("\nCaso 5, Destruir disparo por chocar con suelo" +
                            "\nsalida esperada: shot.isVisible == false    salida código: shot.isVisible == " +  shot.isVisible());

                }
        );

    }



    @Test
    public void update_aliens(){

        board.gameInit();
        assertAll("Pruebas de clase de equivalencia del método update_aliens: ",
                () -> {
                    board.setDirection(1);
                    board.getAliens().get(8).setX(330);
                    board.getAliens().get(8).setY(5);
                    board.update_aliens();
                    assertEquals(20, board.getAliens().get(8).getY(), "Caso 1: \nsalida esperada : 20 \nsalida final: " + board.getAliens().get(8).getY());
                    System.out.println("Caso 1: \nsalida esperada : 20 \nsalida final: " + board.getAliens().get(8).getY());

                }, () -> {

                    board.setDirection(-1);
                    board.getAliens().get(9).setX(2);
                    board.getAliens().get(9).setY(5);
                    board.update_aliens();
                    assertEquals(20, board.getAliens().get(9).getY(), "Caso 2: \nsalida esperada : 20 \nsalida final: " + board.getAliens().get(9).getY());
                    System.out.println("Caso 2: \nsalida esperada : 20 \nsalida final: " + board.getAliens().get(9).getY());

                }, () -> {
                    board.setDirection(1);
                    board.getAliens().get(0).setX(150);
                    board.getAliens().get(0).setY(5);
                    board.update_aliens();
                    assertEquals(5, board.getAliens().get(0).getY(), "Caso 3: \nsalida esperada : 5 \nsalida final: " + board.getAliens().get(0).getY());
                    System.out.println("Caso 3: \nsalida esperada : 5 \nsalida final: " + board.getAliens().get(0).getY());

                }, () -> {

                    board.setDirection(1);
                    board.getAliens().get(1).setX(150);
                    board.getAliens().get(1).setY(280);
                    board.update_aliens();
                    assertEquals("Invasion!", board.getMessage(), "Caso 4: \nsalida esperada : Invasion! \nsalida final: " + board.getMessage());
                    System.out.println("Caso 4: \nsalida esperada : Invasion! \nsalida final: " + board.getMessage());

                }
        );

    }


    @Test
    public void update_bomb(){
        board.gameInit();
        board.getPlayer().setX(180);
        board.getPlayer().setY(280);
        assertAll("Pruebas de clase de equivalencia del método update_bomb: ",
                () -> {
                    board.getAliens().get(0).getBomb().setX(100);
                    board.getAliens().get(0).getBomb().setY(290);
                    board.getAliens().get(0).getBomb().setDestroyed(false);
                    board.update_bomb();
                    assertTrue(board.getAliens().get(0).getBomb().isDestroyed(), "Caso 1: \nsalida esperada : true \nsalida final: " + board.getAliens().get(0).getBomb().isDestroyed());
                    System.out.println("Caso 1: destruir bomba \nsalida esperada : true \nsalida final: " + board.getAliens().get(0).getBomb().isDestroyed());

                }, () -> {

                    board.getAliens().get(6).getBomb().setX(180);
                    board.getAliens().get(6).getBomb().setY(280);
                    board.getAliens().get(6).getBomb().setDestroyed(false);
                    board.update_bomb();

                    assertTrue(board.getPlayer().isDying(), "Caso 2: \nsalida esperada : true \nsalida final: " + board.getPlayer().isDying());
                    System.out.println("Caso 2: player died\nsalida esperada : true \nsalida final: " + board.getPlayer().isDying());

                }, () -> {
                    board.getAliens().get(2).getBomb().setY(200);
                    board.getAliens().get(2).getBomb().setX(100);
                    board.getAliens().get(2).getBomb().setDestroyed(false);
                    board.update_bomb();
                    assertTrue(board.getAliens().get(2).getBomb().getY() == 201,
                            "Caso 3: bomba Y +1 \nsalida esperada : true \nsalida final: " + (board.getAliens().get(2).getBomb().getY()));
                    System.out.println("Caso 3: bomba Y +1 \nsalida esperada : true \nsalida final: " + (board.getAliens().get(2).getBomb().getY()));

                }, () -> {
                    board.getAliens().get(3).getBomb().setY(280);
                    board.getAliens().get(3).getBomb().setX(100);
                    board.getAliens().get(3).getBomb().setDestroyed(false);
                    board.update_bomb();
                    assertTrue(board.getAliens().get(3).getBomb().getY() == 281,
                            "Caso 4: bomba Y +1 \nsalida esperada : true \nsalida final: " + (board.getAliens().get(3).getBomb().getY()));
                    System.out.println("Caso 4: bomba Y +1 \nsalida esperada : true \nsalida final: " + (board.getAliens().get(3).getBomb().getY()));

                }




        );



    }


    }
