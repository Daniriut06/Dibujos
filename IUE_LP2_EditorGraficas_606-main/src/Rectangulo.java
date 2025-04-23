import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Rectangulo extends Trazo {

    public Rectangulo(int x1, int y1, int x2, int y2) {
        super(x1, y1, x2, y2);

    }

    @Override
    public void dibujar(Graphics g, Color color, Estado estado) {
        Graphics2D g2 = (Graphics2D) g;
        switch (estado) {
            case SELECCIONANDO:
                g2.setColor(color);
                
                g2.setStroke(new BasicStroke(3));
                g.drawRect(getXminimo(), getYminimo(), getAncho(), getAlto());
                
                break;

            default:
                g.setColor(color);
                g.drawRect(getXminimo(), getYminimo(), getAncho(), getAlto());
                break;
        }
    }

    @Override
    public boolean cercano(int x, int y) {
        int minX = Math.min(getX1(), getX2());
        int maxX = Math.max(getX1(), getX2());
        int minY = Math.min(getY1(), getY2());
        int maxY = Math.max(getY1(), getY2());

        return (Trazo.esCercanoALinea(x, y, minX, minY, maxX, maxY) ||
                Trazo.esCercanoALinea(x, y, maxX, maxY, maxX, maxY) ||
                Trazo.esCercanoALinea(x, y, minX, maxY, maxX, maxY) ||
                Trazo.esCercanoALinea(x, y, minX, minY, minX, maxY));

    }

}
