import java.awt.Color;
import java.awt.Graphics;

public class Ovalo extends Trazo {

    public Ovalo(int x1, int y1, int x2, int y2) {
        super(x1, y1, x2, y2);
        
    }

    @Override
    public void dibujar(Graphics g, Color color) {
        g.setColor(color);
        g.drawOval(getXminimo(), getYminimo(), getAncho(), getAlto());
    }

}
