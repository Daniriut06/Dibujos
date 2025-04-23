import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Ovalo extends Trazo {

    public Ovalo(int x1, int y1, int x2, int y2) {
        super(x1, y1, x2, y2);

    }

    @Override
    public void dibujar(Graphics g, Color color, Estado estado) {
        Graphics2D g2 = (Graphics2D) g;
        switch (estado) {
            case SELECCIONANDO:
                g2.setColor(color);
                g2.setStroke(new BasicStroke(3));
                g.drawOval(getXminimo(), getYminimo(), getAncho(), getAlto());

                break;

            default:
                g.setColor(color);
                g.drawOval(getXminimo(), getYminimo(), getAncho(), getAlto());
                break;
        }

    }

    @Override
    public boolean cercano(int x, int y) {
        int xCentro = (getX1() + getX2()) / 2;
        int yCentro = (getY1() + getY2()) / 2;
        int radioX = Math.abs(getX2() - getX1()) / 2;
        int radioY = Math.abs(getY2() - getY1()) / 2;

        double ecuacionElipse = Math.pow((x - xCentro) / (double) radioX, 2)
                + Math.pow((y - yCentro) / (double) radioY, 2);

        double distanciaElipse = Math.abs(1.0 - ecuacionElipse) * Math.max(radioX, radioY);

        return distanciaElipse <= Trazo.TOLERANCIA;
    }

}
