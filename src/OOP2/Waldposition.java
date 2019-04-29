package OOP2;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Josis
 */
public class Waldposition {
    private Vector2 position;
    private FeldTyp typ;

    public Waldposition()
    {
        this(new Vector2(), FeldTyp.Förster);
    }

    public Waldposition(Vector2 position, FeldTyp typ){

    }

    public void setPosition(Vector2 vector2)
    {
        throw new NotImplementedException();
    }

    public Vector2 getPosition()
    {
        throw new NotImplementedException();
    }

    public void setTyp(FeldTyp typ)
    {
        throw new NotImplementedException();
    }

    public FeldTyp getTyp()
    {
        throw new NotImplementedException();
    }

}
