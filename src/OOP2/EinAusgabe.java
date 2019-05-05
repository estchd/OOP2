package OOP2;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

/**
 * @author Josi
 */
public class EinAusgabe {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * @author Josi
     *
     * Liest die nächste Zeile der Konsoleneingabe aus.
     * @return Konsoleneingabe als String
     */
    public static String textEingabe()
    {
        return Scanner.nextLine();
    }

    /**
     * @author Josi
     *
     * Gibt den eingegebenen String auf der Konsole aus.
     * @param textausgabe : Konsolenausgabe als String
     */
    public static void textAusgabe(String textausgabe)
    {
        System.out.println(textausgabe);
    }

    /**
     * @author Josi
     *
     * Konsolenabfrage nach einer Zahl.
     * @param frage : String der auf der Konsole ausgegeben werden soll.
     * @return zahl : abgefragte Zahl als Integer.
     */
    public static int intAbfrage(String frage)
    {
        textAusgabe(frage);
        String eingabe = textEingabe().trim().toLowerCase().replaceAll("[\\D]", "");
        int zahl;
        boolean weiterfragen = true;
        while (weiterfragen) {
            try {
                zahl = Integer.parseInt(eingabe);
                weiterfragen = false;
            } catch (NumberFormatException nf) {
                System.out.println("Eingegebener Wert ist keine Zahl! Bitte erneut eingeben.");
                weiterfragen = true;
            } catch (Exception e) {
                System.out.println("Eingegebener Wert ist ungültig! Bitte erneut eingeben.");
                weiterfragen = true;
            }
        }

       return zahl;
    }

    /**
     * @author Josi
     *
     * Eine Abfrage nach der Position, erst nach dem x-Wert und dann nach dem y-Wert als Integer.
     * @param frage : Konsolenausgabe
     * @return vector : Position als Vector2
     */
    public static Vector2 positionsAbfrage(String frage, Wald wald)
    {
        //TODO Bitte auf Spielfeldgröße achten!
        textAusgabe(frage);
        boolean weiterfragen = false;
        int x;
        int y;

            x = intAbfrage("Bitte x eingeben!");

            y = intAbfrage("Bitte Y eingeben!");
        Vector2 vector = new Vector2(x,y);
        return vector;
    }

    /**
     * @author Josi
     *
     * Eine Abfrage über mehrere Auswahlmöglichkeiten, jedes mit einer Nummer ausgegeben.
     * @param frage : Konsolenausgabe als String
     * @param möglichkeiten : Auswahlmöglichkeiten als Liste von Strings
     * @return auswahl : ausgewählte Nummer als Integer
     */
    public static int auswahlAbfrage(String frage, List<String> möglichkeiten)
    {
        textAusgabe(frage);
        int i = 0;
        for (String s : möglichkeiten) {
            textAusgabe(i + ": " + s);
            i++;
        }
        int auswahl = intAbfrage("Bitte die gewählte Nummer eingeben!")
        return auswahl;
    }

}
