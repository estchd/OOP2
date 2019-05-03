package OOP2;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * @author Josi
 */
public class Waldposition {
    private Vector2 position;
    private FeldTyp typ;

    public Waldposition()
    {
        this(new Vector2(), FeldTyp.Förster);
    }

    public Waldposition(Vector2 position, FeldTyp typ){
        this.position = position;
        this.typ = typ;
    }

    public void setPosition(Vector2 vector2)
    {
        position = vector2;
    }

    public Vector2 getPosition()
    {
        return position;
    }

    public void setTyp(FeldTyp ftyp)
    {
        this.typ = ftyp;
    }

    public FeldTyp getTyp()
    {
        return typ;
    }

}
