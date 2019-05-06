package OOP2;

public class Test2 {

    /**
     * @author Josi
     *
     * Führt die Zweite Testserie durch
     */

    public static void test2(){
        int breite = EinAusgabe.intAbfrage("Wie breit ist der Wald?");
        int höhe = EinAusgabe.intAbfrage("Wie hoch ist der Wald?");
        Wald wald = new Wald(höhe,breite);

        wald.berechneMaximaleSichtbarkeiten();
    }
}
