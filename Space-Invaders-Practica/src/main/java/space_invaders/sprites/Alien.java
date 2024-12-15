package space_invaders.sprites;

import main.Commons;

import javax.swing.ImageIcon;

public class Alien extends Sprite {

    private Bomb bomb;

    /**
     * Inicializa un nuevo alien
     * @param x coordenada X de la posición del nuevo alien
     * @param y coordenada Y de la posición del nuevo alien
     * */
    public Alien(int x, int y) {
        System.out.println("------------Pasar el control al constructor de initPlayer---------------");
        System.out.println("Antes de llamar al método initAlien: alien no instanciada");
        initAlien(x, y);
       System.out.println("Instancia alien en posición indicada:" +
        "\n Alien posición esperada: X = " + x + "  Y = " + y +
        "\n Alien posición final: X = " + this.x + "  Y = " + this.y);
        System.out.println("------------Devolver el control al constructor de Alien---------------");
    }

    public Alien(){

    }
    /**
     * Inicializa un nuevo alien y le asigna la imagen correspondiente en la interfaz
     * @param x coordenada X de la posición del nuevo alien
     * @param y coordenada Y de la posición del nuevo alien
     * Si alguna de las coordenadas indicadas supera los márgenes de la pantalla, se ubicará en el máximo permitido.
     * Por ejemplo, si la coordenada X indicada supera el margen de la pantalla, se asignará a X el valor máximo posible, es decir, el ancho de la pantalla.
     * Si se introduce alguna coordenada negativa, se reemplazará por 0.
     * */
    public void initAlien(int x, int y) {
        //hemos modificado el orden de condición separado la comprobación de los límites de X e Y
        this.x = x;
        this.y = y;

        if (x> Commons.BOARD_WIDTH){
            this.x = Commons.BOARD_WIDTH;
        } else if (x<0){
            this.x = 0;
        }

        if (y> Commons.BOARD_HEIGHT){
            this.y = Commons.BOARD_HEIGHT;
        } else if (y<0){
            this.y=0;
        }
        System.out.println("------------Pasar el control al constructor de Bomb---------------");
        System.out.println("Antes de ejecutar el constructor de bomba: Bomba no instanciada");
        bomb = new Bomb(x, y);
        System.out.println("Instanciar bomba en la posición de alien: "
        + "\n posicion alien: X = " + x + " y = " + y
        + "\n posición bomb: X = " + this.bomb.getX() + " y = " + this.bomb.getY());
        System.out.println("------------Devolver el control al InitBomb ---------------");

        var alienImg = "src/main/resources/images/alien.png";
        var ii = new ImageIcon(alienImg);

        setImage(ii.getImage());
    }

    /**
     * Mueve horizontalmente el alien en la dirección indicada.
     * @param direction posición hacia la izquierda o derecha hacia la que se mueve el alien
     * */
    public void act(int direction) {

        this.x += direction;//hemos quitado alien width, y modificado = a +=

    }

    /**
     * Devuelve el objeto explosión asociado al alien
     * @return bomb
     * */
    public Bomb getBomb() {

        return bomb;
    }

    public void setBomb(Bomb bomb) {
        this.bomb = bomb;
    }

    public class Bomb extends Sprite {

        private boolean destroyed;

        /**
         * Crea una nueva bomba en la posición indicada
         * @param x coordenada X de la posición de la nueva explosión
         * @param y coordenada Y de la posición de la nueva explosión
         * */

        public Bomb(int x, int y) {
            System.out.println("------------Pasar el control al InitBomb---------------");
            System.out.println("Antes de instanciar la bomba por el alien: No hay bomba instanciada ");
            initBomb(x, y);
             System.out.println("posición esperada de la Bomba instanciada: X = " + x + ", Y = " + y
            + "\nposición final de la bomba instanciada: X = " + this.x + ", Y = " + this.y);
            System.out.println("------------Devolver el control al constructor de Bomb---------------");
        }

        /**
         * Inicializa el nuevo objeto bomba y le asigna las coordenadas indicadas y la imagen correspondiente en la interfaz
         * @param x coordenada X de la posición de la nueva bomba
         * @param y coordenada Y de la posición de la nueva bomba
         * Si el valor X o Y indicados superan el margen de la pantalla, se les asignará el valor máximo permitido.
         * Si se introduce algún valor negativo, será reemplazado por 0.
         * */
        private void initBomb(int x, int y) {

            setDestroyed(true);
            //hemos modificado el orden de condición separado la comprobación de los límites de X e Y
            this.x = x;
            this.y = y;
            if (x>= Commons.BOARD_WIDTH){
                this.x = Commons.BOARD_WIDTH;
            }else if (x<0){
                this.x = 0;
            }

            if (y>= Commons.BOARD_HEIGHT){
                this.y = Commons.BOARD_HEIGHT;
            }else if (y<0){
                this.y = 0;
            }

            var bombImg = "src/main/resources/images/bomb.png";
            var ii = new ImageIcon(bombImg);
            setImage(ii.getImage());
        }

        /**
         * Cambia el valor de "destruido" al valor asignado
         * @param destroyed
         * */
        public void setDestroyed(boolean destroyed) {

            this.destroyed = destroyed;
        }
        /**
         * Comprueba si la bomba ha sido destruida
         * @return destroyed
         * */
        public boolean isDestroyed() {

            return destroyed;
        }
    }
}
