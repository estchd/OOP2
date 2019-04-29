package OOP2;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Wald {
    private int höhe;
    private int breite;
    private List<List<Waldposition>> positionen;

    /**
     * @author Erik
     * @param höhe
     * @param breite
     */
    public Wald(int höhe, int breite)
    {
        this.höhe = höhe;
        this.breite = breite;
    }

    /**
     * @author Erik
     * @param position
     * @return
     */
    public Sichtbarkeitsmatrix berechneSichtbarkeit(Vector2 position)
    {
        Vector2 listPosition = new Vector2((int)position.GetX(),(int)position.GetY());

        if(listPosition.GetX() < 0 || listPosition.GetY() < 0)
        {
            throw new IllegalArgumentException("Position kann nicht negativ sein!");
        }
        if(listPosition.GetX() >= breite ||listPosition.GetY() >= höhe)
        {
            throw new IllegalArgumentException("Position zu groß!");
        }

        Map<Vector2, Vector2> sichtbareBäume = new HashMap<Vector2,Vector2>();

        for(int y = 0; y < höhe; y++){
            for(int x = 0; x < breite; x++){

                Vector2 pos = new Vector2(x,y);

                if(pos.equals(listPosition))
                {
                    continue;
                }

                Vector2 försterZuBaum = pos.SubVector2(listPosition);
                Vector2 richtungBaum = försterZuBaum.GetNormalized();

                if(sichtbareBäume.containsKey(richtungBaum)){
                    Vector2 gespeicherterBaum = sichtbareBäume.get(richtungBaum);

                    if(gespeicherterBaum.GetLength() > försterZuBaum.GetLength()){
                        sichtbareBäume.replace(richtungBaum,försterZuBaum);
                    }
                }
                else{
                    sichtbareBäume.put(richtungBaum, försterZuBaum);
                }

            }
        }

        Sichtbarkeitsmatrix result = new Sichtbarkeitsmatrix(breite, höhe);
        List<List<SichtbarkeitsTyp>> matrix = result.GetMatrix();
        matrix.get((int)listPosition.GetY()).set((int)listPosition.GetX(), SichtbarkeitsTyp.Förster);

        for (Vector2 försterZuBaum : sichtbareBäume.values()) {
            Vector2 baumPos = listPosition.AddVector2(försterZuBaum);

            matrix.get((int) baumPos.GetY()).set((int)baumPos.GetX(), SichtbarkeitsTyp.SichtbarerBaum);
        }

        for(int y = 0; y < matrix.size(); y++){
            for(int x = 0; x < matrix.get(0).size(); x++){
                if(matrix.get(y).get(x) == SichtbarkeitsTyp.None){
                    matrix.get(y).set(x,SichtbarkeitsTyp.UnsichtbarerBaum);
                }
            }
        }

        result.SetMatrix(matrix);

        return result;
    }

    public List<Vector2> berechneMaximaleSichtbarbeiten()
    {
        throw new NotImplementedException();

        //erstelle DICT/Map <positionsvektor, Sichtbarkeitsmatrix>
        //setzte int maxBäume auf 0
        //
        //für alle waldpositionen
        //  berechne sichtbarkeit
        //  wenn anzSichtbareBäume an position größer maxBäume
        //      verwerfe inhalt von DICT
        //      speichere sichtbarkeitsmatrix mit position in DICT
        //      setzte maxbäume auf anzSichtbareBäume
        //  sonst wenn anzSichtbareBäume gleich maxBäume
        //      speichere sichtbarkeitsmatrix mit position in DICT
        //
        //Gib Liste der DICT keys aus (evt auch matrizen)
    }
}
