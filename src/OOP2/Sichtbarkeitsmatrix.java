package OOP2;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

/**
 * @autor Erik
 */
public class Sichtbarkeitsmatrix {
    private List<List<SichtbarkeitsTyp>> matrix;
    private int anzSichtbareBäume;

    /**
     * @author Erik
     * @param breite
     * @param höhe
     */
    public Sichtbarkeitsmatrix(int breite, int höhe)
    {
        matrix = new ArrayList<>();
        for(int y = 0; y < höhe; y++)
        {
            ArrayList<SichtbarkeitsTyp> row = new ArrayList<>();
            for(int x = 0; x < breite; x++)
            {
                row.add(SichtbarkeitsTyp.None);
            }
            matrix.add(row);
        }
        anzSichtbareBäume = 0;
    }

    /**
     * @author Erik
     * @return
     */
    public int GetAnzSichtbareBäume()
    {
        return anzSichtbareBäume;
    }

    /**
     * @author Erik
     * @return
     */
    public List<List<SichtbarkeitsTyp>> GetMatrix()
    {
        return matrix;
    }

    /**
     * @author Erik
     * @param matrix
     */
    public void SetMatrix(List<List<SichtbarkeitsTyp>> matrix)
    {
        anzSichtbareBäume = 0;

        for(List<SichtbarkeitsTyp> row : matrix)
        {
            for(SichtbarkeitsTyp typ : row)
            {
                if(typ == SichtbarkeitsTyp.SichtbarerBaum)
                {
                    anzSichtbareBäume++;
                }
            }
        }
        this.matrix = matrix;
    }

    /**
     * @author Erik
     * @return
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for(List<SichtbarkeitsTyp> row : matrix)
        {
            StringBuilder rowString = new StringBuilder();
            for(SichtbarkeitsTyp typ : row)
            {
                switch (typ)
                {
                    case None:
                        rowString.append(" ");
                        break;

                    case Förster:
                        rowString.append("@");
                        break;

                    case SichtbarerBaum:
                        rowString.append("#");
                        break;

                    case UnsichtbarerBaum:
                        rowString.append("|");
                        break;
                }
            }
            rowString.append("\n");
            result.append(rowString);
        }

        return result.toString();
    }
}
