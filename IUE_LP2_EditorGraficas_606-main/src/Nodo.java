import java.awt.Color;

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

}
