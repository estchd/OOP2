package OOP2;


public class Test1 {

    /**
     * @author Erik
     * Führt die erste Testserie durch
     */
    public static void test1(){
        int breite = EinAusgabe.intAbfrage("Wie breit ist der Wald?");
        int höhe = EinAusgabe.intAbfrage("Wie hoch ist der Wald?");
        Vector2 försterPosition = EinAusgabe.positionsAbfrage("Wo steht der Förster?");
        Wald wald = new Wald(höhe,breite);

        Sichtbarkeitsmatrix matrix = wald.berechneSichtbarkeit(försterPosition);

        System.out.println("Förster an Position ("+försterPosition.getX()+","+försterPosition.getY()+") sieht "+matrix.getAnzSichtbareBäume()+" Bäume!");
        System.out.println("Sichtbarkeitsmatrix:");
        System.out.print(matrix.toString());
    }
}
