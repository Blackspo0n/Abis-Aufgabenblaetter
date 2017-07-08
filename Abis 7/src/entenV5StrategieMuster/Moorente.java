package entenV5StrategieMuster;

public class Moorente extends Ente {

    //Im Konstruktur das passende Verhalten auswählen
    public Moorente() {
        quakVerhalten = new Quaken();
        flugVerhalten = new FliegtMitFluegeln();
    }

    @Override
    public void anzeigen() {
        System.out.println("Ich bin eine scheue Moorente.");
    }
}
