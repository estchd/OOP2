package OOP2;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
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

        positionen = new ArrayList<>();

        for(int y = 0; y < höhe; y++){
            positionen.add(new ArrayList<>());
            for(int x = 0; x < breite; x++){
                positionen.get(y).add(new Waldposition(new Vector2(x,y),FeldTyp.Baum));
            }
        }
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

        FeldTyp typVorher = positionen.get((int)listPosition.GetY()).get((int)listPosition.GetX()).getTyp();
        positionen.get((int)listPosition.GetY()).set((int)listPosition.GetX(),new Waldposition(listPosition, FeldTyp.Förster));

        Map<Vector2, Vector2> sichtbareBäume = new HashMap<Vector2,Vector2>();

        for(int y = 0; y < höhe; y++){
            for(int x = 0; x < breite; x++){

                Vector2 pos = new Vector2(x,y);

                if(positionen.get(y).get(x).getTyp() == FeldTyp.Förster || positionen.get(y).get(x).getTyp() == FeldTyp.None)
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
        List<List<SichtbarkeitsTyp>> matrix = result.getMatrix();

        for(int y = 0; y < höhe; y++){
            for(int x = 0; x < breite; x++){
                FeldTyp typ = positionen.get(y).get(x).getTyp();
                switch(typ){
                    case None:
                        matrix.get(y).set(x,SichtbarkeitsTyp.None);
                        break;

                    case Förster:
                        matrix.get(y).set(x,SichtbarkeitsTyp.Förster);
                        break;

                    case Baum:
                        matrix.get(y).set(x,SichtbarkeitsTyp.UnsichtbarerBaum);
                        break;
                }
            }
        }

        for (Vector2 vec : sichtbareBäume.values()) {
            Vector2 baumPos = vec.AddVector2(listPosition);

            matrix.get((int)baumPos.GetY()).set((int)baumPos.GetX(),SichtbarkeitsTyp.SichtbarerBaum);
        }

        result.setMatrix(matrix);

        positionen.get((int)listPosition.GetY()).set((int)listPosition.GetX(),new Waldposition(listPosition, typVorher));

        return result;
    }

    /**
     * @author Josi
     *
     * Die Funktion berechnet die maximale Anzahl an Bäumen die sichtbar sind,
     * sowie die Positionen an denen der Förster dafür stehen muss, und gibt diese auf der Konsole aus.
     * @return positionslist : Liste an Positionen des Förster, wo dieser die maximale Anzahl an Bäumen sieht
     */
    public List<Vector2> berechneMaximaleSichtbarkeiten()
    {
        HashMap<Vector2, Sichtbarkeitsmatrix> waldmap = new HashMap<Vector2, Sichtbarkeitsmatrix>();
        int maxBaume = 0;
        for (int x = 0; x< breite; x++) {
            for (int y=0; y< höhe; y++) {
                Vector2 position = new Vector2(x,y);
                Sichtbarkeitsmatrix matrix = berechneSichtbarkeit(position);
                if (matrix.getAnzSichtbareBäume() > maxBaume) {
                    waldmap = new HashMap<Vector2, Sichtbarkeitsmatrix>();
                    waldmap.put(position, matrix);
                    maxBaume = matrix.getAnzSichtbareBäume();
                } else if (matrix.getAnzSichtbareBäume() == maxBaume) {
                    waldmap.put(position, matrix);
                }
            }
        }
        System.out.println("Die maximale Anzahl sichtbarer Bäume beträägt: " + maxBaume );
        System.out.println("und diese sieht der Förster an folgenden Positionen: ");
        for (Map.Entry<Vector2, Sichtbarkeitsmatrix> entry : waldmap.entrySet()) {
            System.out.println("Position: " + entry.getKey());
            System.out.println(entry.getValue());
        }
        ArrayList<Vector2> positionslist = new ArrayList<Vector2>();
        positionslist.addAll(waldmap.keySet());
        return positionslist;

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
