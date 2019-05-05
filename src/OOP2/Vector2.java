package OOP2;

/**
 * @author Erik
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
     * @param x
     * @param y
     */
    public Vector2(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * @author Erik
     * @return
     */
    public double GetX()
    {
        return this.x;
    }

    /**
     * @author Erik
     * @param x
     */
    public void SetX(double x)
    {
        this.x = x;
    }

    /**
     * @author Erik
     * @return
     */
    public double GetY()
    {
        return this.y;
    }

    /**
     * @author Erik
     * @param y
     */
    public void SetY(double y)
    {
        this.y = y;
    }

    /**
     * @author Erik
     * @return
     */
    public double GetLength()
    {
        return Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
    }

    /**
     * @author Erik
     * @return
     */
    public Vector2 GetNormalized()
    {
        double factor = 1/GetLength();
        return new Vector2(this.x * factor, this.y * factor);
    }

    /**
     * @author Erik
     * @param other
     * @return
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

    @Override
    public int hashCode() {
        return (int)this.x+(int)this.y;
    }

    @Override
    public String toString(){
        return "(" + this.x + "|" + this.y + ")";
    }

    /**
     * @author Erik
     * @param other
     * @return
     */
    public Vector2 SubVector2(Vector2 other)
    {
        return new Vector2(this.x - other.x, this.y - other.y);
    }

    /**
     * @author Erik
     * @param other
     * @return
     */
    public Vector2 AddVector2(Vector2 other)
    {
        return new Vector2(this.x + other.x, this.y + other.y);
    }
}
