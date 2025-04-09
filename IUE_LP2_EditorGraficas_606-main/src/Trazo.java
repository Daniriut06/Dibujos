import java.awt.Color;
import java.awt.Graphics;

public abstract class Trazo {
    private int x1, y1, x2, y2;

    public Trazo(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public int getAncho() {

        return Math.abs(x2 - x1) + 1;

    }

    public int getAlto() {

        return Math.abs(y2 - y1) + 1;
    }

    public int getXminimo(){
        return Math.min(x1, x2);
    }

    public int getYminimo(){
        return Math.min(y1, y2);
    }


    public abstract void dibujar(Graphics g, Color color);
}
