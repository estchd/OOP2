package OOP2;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class Wald {
    private int höhe;
    private int breite;
    private List<List<Waldposition>> positionen;

    public Wald(int höhe, int breite)
    {

    }

    public int berechneSichtbarkeit(Vector2 position)
    {
        throw new NotImplementedException();

        //nimm position
        //für alle positionen in wald
        //  berechne richtungsvektor von förster zu baum
        //  speichere vectoren in DICT <richtungsvektor , vector>
        //  wenn richtungsvektor schon vorhanden
        //      vergleiche länge der vectoren und speichere kürzeren ab
        //
        //erstelle neue sichtbarkeitsmatrix
        //
        //setzte anzahlSichtbareBäume auf länge des DICTS
        //
        //setzte försterposition
        //für alle richtungsvektoren in DICT
        //  berechne baumposition (  position + vector )
        //  setzte position in sichtbarkeitsmatrix als sichtbarer baum
        //
        //für alle noch nicht besetzten positionen in der sichtbarkeitsmatrix
        //  setze position in sichtbarkeitsmatrix auf unsichtbarer baum
        //
        // gib sichtbarkeitsmatrix aus
    }

    public List<Vector2> berechneMaximaleSichtbarbeiten()
    {
        throw new NotImplementedException();

        //erstelle DICT <positionsvektor, Sichtbarkeitsmatrix>
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
