package entenV5StrategieMuster;

public class Gummiente extends Ente {

    //Im Konstruktur das passende Verhalten auswählen
    public Gummiente() {
        quakVerhalten = new Quietschen();
        flugVerhalten = new FliegtGarNicht();
    }

    @Override
    public void anzeigen() {
        System.out.println("Ich bin eine elastische Gummiente.");
    }
}
