package OOP2;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

/**
 * @author Josis
 */
public class EinAusgabe {
    private static final Scanner scanner = new Scanner(System.in);

    public static String textEingabe()
    {
        return Scanner.nextLine();
    }

    public static void textAusgabe()
    {
        System.out.println(textausgabe);
    }

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
            }
        } catch (Exception e) {
        System.out.println("Eingegebener Wert ist keine Zahl! Bitte erneut eingeben.");
        weiterfragen = true;
        }

       return zahl;
    }

    public static Vector2 positionsAbfrage(String frage)
    {
        //TODO Bitte auf Spielfeldgröße achten!
        textAusgabe(frage);
        int x = intAbfrage("Bitte x eingeben!");
        int y = intAbfrage("Bitte Y eingeben!");
        Vector2 vector = new Vector2(x,y);
        return vector;
    }

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
