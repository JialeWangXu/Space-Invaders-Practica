
import main.Board;
import main.Commons;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import space_invaders.sprites.Alien;
import space_invaders.sprites.Player;
import space_invaders.sprites.Shot;
import space_invaders.sprites.Sprite;

import java.awt.event.KeyEvent;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class BoardTest {
    private Board board;

    @BeforeEach
    public void setUp(){board = new Board();}

    @Test
    public void gameInit(){
        board.gameInit();
        assertAll("Pruebas de valor límite del método initAlien: ",
                () -> {
                    assertEquals(150,board.getAliens().get(0).getX(),"Caso 1: \nsalida esperada de X: 150 \nsalida final: " + board.getAliens().get(0).getX());
                    assertEquals(5,board.getAliens().get(0).getY(),"Caso 1: \nsalida esperada de Y: 5 \nsalida final: " + board.getAliens().get(0).getY());
                },() -> {


                    assertEquals(168,board.getAliens().get(1).getX(),"Caso 2: \nsalida esperada de X: 168 \nsalida final: " + board.getAliens().get(1).getX());
                    assertEquals(5,board.getAliens().get(1).getY(),"Caso 2: \nsalida esperada de Y: 5 \nsalida final: " + board.getAliens().get(1).getY());
                },() -> {


                    assertEquals(186,board.getAliens().get(2).getX(),"Caso 3: \nsalida esperada de X: 186 \nsalida final: " + board.getAliens().get(2).getX());
                    assertEquals(5,board.getAliens().get(2).getY(),"Caso 3: \nsalida esperada de Y: 5 \nsalida final: " + board.getAliens().get(2).getY());
                },() -> {


                    assertEquals(222,board.getAliens().get(22).getX(),"Caso 4: \nsalida esperada de X: 222 \nsalida final: " + board.getAliens().get(22).getX());
                    assertEquals(59,board.getAliens().get(22).getY(),"Caso 4: \nsalida esperada de Y: 59 \nsalida final: " + board.getAliens().get(22).getY());
                },() -> {


                    assertEquals(240,board.getAliens().get(23).getX(),"Caso 5: \nsalida esperada de X: 240 \nsalida final: " + board.getAliens().get(23).getX());
                    assertEquals(59,board.getAliens().get(23).getY(),"Caso 5: \nsalida esperada de Y: 59 \nsalida final: " + board.getAliens().get(23).getY());
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
                    board.setDirection(-1);
                    board.getAliens().get(8).setX(330);
                    board.getAliens().get(8).setY(5);
                    board.update_aliens();
                    assertEquals(20, board.getAliens().get(8).getY(), "Caso 1: \nsalida esperada : 20 \nsalida final: " + board.getAliens().get(8).getY());
                    System.out.println("Caso 1: \nsalida esperada : 20 \nsalida final: " + board.getAliens().get(8).getY());

                }, () -> {

                    board.setDirection(1);
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

                }, () -> {

                    board.setDirection(1);
                    board.getAliens().get(0).setX(150);
                    board.getAliens().get(0).setY(277);
                    board.update_aliens();
                    assertEquals("", board.getMessage(), "Caso 5: \nsalida esperada : Invasion! \nsalida final: " + board.getMessage());
                    System.out.println("Caso 5: \nsalida esperada :  \nsalida final: " + board.getMessage());

                }
        );

    }


    @Test
    public void update_bomb(){
        board.gameInit();
        assertAll("Pruebas de clase de equivalencia del método update_bomb: ",
                () -> {

                    board.getAliens().get(0).getBomb().setY(285);
                    board.update_bomb();
                    assertEquals(true, board.getAliens().get(0).getBomb().isDestroyed(), "Caso 1: \nsalida esperada : true \nsalida final: " + board.getAliens().get(0).getBomb().isDestroyed());
                    System.out.println("Caso 1: \nsalida esperada : true \nsalida final: " + board.getAliens().get(0).getBomb().isDestroyed());

                }, () -> {
                    board.getShot().setX(150);
                    board.getShot().setY(35);
                    board.getAliens().get(1).getBomb().setY(30);
                    board.getAliens().get(1).getBomb().setX(150);
                    board.update_bomb();
                    assertEquals(true, board.getAliens().get(1).getBomb().isDestroyed(), "Caso 2: \nsalida esperada : true \nsalida final: " + board.getAliens().get(1).getBomb().isDestroyed());
                    System.out.println("Caso 2: \nsalida esperada : true \nsalida final: " + board.getAliens().get(1).getBomb().isDestroyed());

                }, () -> {

                    board.getPlayer().setX(270);
                    board.getPlayer().setY(280);
                    board.getAliens().get(2).getBomb().setY(280);
                    board.getAliens().get(2).getBomb().setX(270);
                    board.update_bomb();
                    assertEquals(true, board.getPlayer().isDying(), "Caso 3: \nsalida esperada : true \nsalida final: " + board.getPlayer().isDying());
                    System.out.println("Caso 3: \nsalida esperada : true \nsalida final: " + board.getPlayer().isDying());

                }



        );



    }

    }
