package entenV5StrategieMuster;

public class Lockente extends Ente {

    //Im Konstruktur das passende Verhalten auswählen
    public Lockente() {
        quakVerhalten = new StummesQuaken();
        flugVerhalten = new FliegtGarNicht();
    }


    @Override
    public void anzeigen() {
        System.out.println("Ich bin eine listige Lockente.");
    }
}
