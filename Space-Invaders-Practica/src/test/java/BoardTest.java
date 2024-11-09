
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

                    assertFalse(board.getAliens().get(0).getX() == 150 && board.getAliens().get(0).getY() == 5 && board.getAliens().size() != 24,
                            "caso 1 : \nsalida esperada de X: 150,  salida final de X: "+ board.getAliens().get(0).getX()
                            +"\nsalida esperada de Y: 5,  salida final de Y:"+ board.getAliens().get(0).getY()
                            +"\nsalida esperada de numero de alien = distinto que 24,  salida final de numero de alien: " + board.getAliens().size());

                    System.out.println("caso 1 : \nsalida esperada de X: 150,  salida final de X: "+ board.getAliens().get(0).getX()
                            +"\nsalida esperada de Y: 5,  salida final de Y:"+ board.getAliens().get(0).getY()
                            +"\nsalida esperada de numero de alien = distinto que 24,  salida final de numero de alien: " + board.getAliens().size());

                },() -> {
                    assertFalse(board.getAliens().get(0).getX() != 150 && board.getAliens().get(0).getY() != 5 && board.getAliens().size() == 24,
                            "caso 2 : \nsalida esperada de X: distinto que 150,  salida final de X: "+ board.getAliens().get(0).getX()
                                    +"\nsalida esperada de Y: distinto que 5,  salida final de Y:"+ board.getAliens().get(0).getY()
                                    +"\nsalida esperada de numero de alien = 24,  salida final de numero de alien: " + board.getAliens().size());
                    System.out.println("caso 2 : \nsalida esperada de X: distinto que 150,  salida final de X: "+ board.getAliens().get(0).getX()
                            +"\nsalida esperada de Y: distinto que  5,  salida final de Y:"+ board.getAliens().get(0).getY()
                            +"\nsalida esperada de numero de alien = distinto que 24,  salida final de numero de alien: " + board.getAliens().size());


                },() -> {
                    assertTrue(board.getAliens().get(0).getX() == 150 && board.getAliens().get(0).getY() == 5 && board.getAliens().size() == 24,
                            "caso 3 : \nsalida esperada de X: 150,  salida final de X: "+ board.getAliens().get(0).getX()
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
                    assertEquals("Game won!", board.getMessage(), "Caso 1: \nsalida esperada : Game won! \nsalida final: " + board.getMessage());
                    System.out.println("Caso 1: \nsalida esperada : Game won! \nsalida final: " + board.getMessage());

                },
                ()->{
                    board.setDeaths(3);
                    board.update();
                    assertEquals("", board.getMessage(), "Caso 2: \nsalida esperada :  \nsalida final: " + board.getMessage());
                    System.out.println("Caso 2: \nsalida esperada :  \nsalida final: " + board.getMessage());
                }
        );

    }

    @Test
    public void update_shots(){



        board.gameInit();

        assertAll("Pruebas de clase de equivalencia del método update_shots: ",
                () -> {
                    int x=board.getAliens().get(0).getX();
                    int y=board.getAliens().get(0).getY();
                    Shot shot = new Shot();
                    shot.setX(x-20);
                    shot.setY(y);
                    board.setShot(shot);
                    board.update_shots();
                    assertEquals(0, board.getDeaths(), "Caso 1: \nsalida esperada : 0 \nsalida final: " + board.getDeaths());
                    System.out.println("Caso 1: \nsalida esperada : 0 \nsalida final: " + board.getDeaths());

                },
                ()->{
                    int x=board.getAliens().get(0).getX();
                    int y=board.getAliens().get(0).getY();
                    Shot shot = new Shot();
                    shot.setX(x+ Commons.ALIEN_WIDTH+20);
                    shot.setY(y);
                    board.setShot(shot);
                    board.setDeaths(0);
                    board.update_shots();
                    assertEquals(0, board.getDeaths(), "Caso 2: \nsalida esperada : 0 \nsalida final: " + board.getDeaths());
                    System.out.println("Caso 2: \nsalida esperada : 0 \nsalida final: " + board.getDeaths());
                },
                ()->{
                    int x=board.getAliens().get(0).getX();
                    int y=board.getAliens().get(0).getY();
                    Shot shot = new Shot();
                    shot.setX(x);
                    shot.setY(y-20);
                    board.setShot(shot);
                    board.setDeaths(0);
                    board.update_shots();
                    assertEquals(0, board.getDeaths(), "Caso 3: \nsalida esperada : 0 \nsalida final: " + board.getDeaths());
                    System.out.println("Caso 3: \nsalida esperada : 0 \nsalida final: " + board.getDeaths());
                },
                ()->{
                    int x=board.getAliens().get(0).getX();
                    int y=board.getAliens().get(0).getY();
                    Shot shot = new Shot();
                    shot.setX(x);
                    shot.setY(y+ Commons.ALIEN_HEIGHT+20);
                    board.setShot(shot);
                    board.setDeaths(0);
                    board.update_shots();
                    assertEquals(0, board.getDeaths(), "Caso 4: \nsalida esperada : 0 \nsalida final: " + board.getDeaths());
                    System.out.println("Caso 4: \nsalida esperada : 0 \nsalida final: " + board.getDeaths());
                },
                ()->{
                    int x=board.getAliens().get(0).getX();
                    int y=board.getAliens().get(0).getY();
                    Shot shot = new Shot();
                    shot.setX(x);
                    shot.setY(y);
                    board.setShot(shot);
                    board.setDeaths(0);
                    board.update_shots();
                    assertEquals(1, board.getDeaths(), "Caso 5: \nsalida esperada : 1 \nsalida final: " + board.getDeaths());
                    System.out.println("Caso 5: \nsalida esperada : 1 \nsalida final: " + board.getDeaths());
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
