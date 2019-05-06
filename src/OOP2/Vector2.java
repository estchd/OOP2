package OOP2;

/**
 * @author Erik
 * Repräsentiert einen Vektor in R x R
 */
public class Vector2
{
    private double x;
    private double y;

    /**
     * @author Erik
     */
    public Vector2()
    {
     this(0,0);
    }

    /**
     * @author Erik
     * @param x Vector X Koordinate
     * @param y Vector Y Koordinate
     */
    public Vector2(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * @author Erik
     * Gibt die X Koordinate des Vectors zurück
     * @return Die X Koordinate des Vectors
     */
    public double getX()
    {
        return this.x;
    }

    /**
     * @author Erik
     * Setzt die X Koordinate des Vectors
     * @param x Die neue X Koordinate des Vektors
     */
    public void setX(double x)
    {
        this.x = x;
    }

    /**
     * @author Erik
     * Gibt die Y Koordinate des Vectors zurück
     * @return Die Y Koordinaate des Vectors
     */
    public double getY()
    {
        return this.y;
    }

    /**
     * @author Erik
     * Setzt die Y Koordinate des Vectors
     * @param y Die neue Y Koordinate des Vectors
     */
    public void setY(double y)
    {
        this.y = y;
    }

    /**
     * @author Erik
     * Berechnet die Länge des Vectors
     * @return Die Länge des Vectors
     */
    public double getLength()
    {
        return Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
    }

    /**
     * @author Erik
     * Berechnet den Einheitsvector des Vectors (Vektor mit selber Richtung, aber Länge 1)
     * @return Der Einheitsvector des Vector
     */
    public Vector2 getNormalized()
    {
        double factor = 1/ getLength();
        return new Vector2(this.x * factor, this.y * factor);
    }

    /**
     * @author Erik
     * Prüft ein Anderes Object auf Gleichheit mit dem Vektor
     * @param other Das Object, welches verglichen werden soll
     * @return Wahr, falls Vector und anderes Object gleich, sonst falsch
     */
    @Override
    public boolean equals(Object other)
    {
        if(!(other instanceof  Vector2)){
            return false;
        }

        Vector2 vec = (Vector2) other;

        return Double.compare(vec.x, this.x) == 0 && Double.compare(vec.y, this.y) == 0;
    }

    /**
     * @author Erik
     * Generiert den Hash Code des Vectors
     * @return Der HashCode des Vectors
     */
    @Override
    public int hashCode() {
        return (int)this.x+(int)this.y;
    }

    /**
     * @author Erik
     * Generiert das String äquivalent des Vectors
     * @return Das String Äquivalent des Vectors
     */
    @Override
    public String toString(){
        return "(" + this.x + "|" + this.y + ")";
    }

    /**
     * @author Erik
     * Subtrahiert einen Vector
     * @param other Der Vector, welcher abgezogen werden soll
     * @return Das Ergebnis der Subtraktion
     */
    public Vector2 subVector2(Vector2 other)
    {
        return new Vector2(this.x - other.x, this.y - other.y);
    }

    /**
     * @author Erik
     * Addiert einen Vector
     * @param other Der Vector, welcher addiert werden soll
     * @return Das Ergebnis der Addition
     */
    public Vector2 addVector2(Vector2 other)
    {
        return new Vector2(this.x + other.x, this.y + other.y);
    }
}
