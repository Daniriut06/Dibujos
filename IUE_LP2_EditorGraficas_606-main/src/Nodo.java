import java.awt.Color;



import entidades.TrazoDTO;

public class Nodo {
    private Trazo trazo;
    private Color color;

    public Nodo siguiente;

    public Trazo getTrazo() {
        return trazo;
    }

    public void setTrazo(Trazo trazo) {
        this.trazo = trazo;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Nodo(Trazo trazo, Color color) {
        this.trazo = trazo;
        this.color = color;
    }

    public TrazoDTO toDTO() {

        return new TrazoDTO(trazo instanceof Linea ? "LINEA" : trazo instanceof Rectangulo ? "RECTANGULO" : "OVALO",
                trazo.getX1(), trazo.getY1(), trazo.getX2(), trazo.getY2(),
                color.getRed(), color.getGreen(), color.getBlue());

    }

}
