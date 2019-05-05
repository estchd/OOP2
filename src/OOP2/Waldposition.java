package OOP2;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * @author Josi
 */
public class Waldposition {
    private Vector2 position;
    private FeldTyp typ;

    /**
     * @author Josi
     * Konstruktor der Waldpositionklasse ohne Parameter
     */
    public Waldposition()
    {
        this(new Vector2(), FeldTyp.Förster);
    }

    /**
     * @author Josi
     * Konstruktor der Waldpositionklasse mit Parameter
     * @param position : Position des Feldtyps als Vector2
     * @param typ : Feldtyp an dieser Position
     */
    public Waldposition(Vector2 position, FeldTyp typ){
        this.position = position;
        this.typ = typ;
    }

    /**
     * @author Josi
     * Setter für Position.
     * @param vector2 : Position als Vector2
     */
    public void setPosition(Vector2 vector2)
    {
        position = vector2;
    }

    /**
     * @author Josi
     * Getter der Position.
     * @return position : Position als Vector2
     */
    public Vector2 getPosition()
    {
        return position;
    }

    /**
     * @author Josi
     * Setter des Feldtyps.
     * @param ftyp : Feldtyp
     */
    public void setTyp(FeldTyp ftyp)
    {
        this.typ = ftyp;
    }

    /**
     * @author Josi
     *
     * Getter des Feldtyps.
     * @return typ : Feldtyp
     */
    public FeldTyp getTyp()
    {
        return typ;
    }

}
