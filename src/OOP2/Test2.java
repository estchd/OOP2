package OOP2;

public class Test2 {
    /**
     * Führt die Zweite Testserie durch
     * @param args Programmargumente
     */
    public static void main(String[] args){
        int breite = EinAusgabe.intAbfrage("Wie breit ist der Wald?");
        int höhe = EinAusgabe.intAbfrage("Wie hoch ist der Wald?");
        Wald wald = new Wald(höhe,breite);

        wald.berechneMaximaleSichtbarkeiten();
    }
}
