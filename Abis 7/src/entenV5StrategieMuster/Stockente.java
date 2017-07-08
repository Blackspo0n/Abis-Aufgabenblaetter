package entenV5StrategieMuster;

public class Stockente extends Ente {

    public Stockente() {
        quakVerhalten = new Quaken();
        flugVerhalten = new FliegtMitFluegeln();
    }

    @Override
    public void anzeigen() {
        System.out.println("Ich bin eine wunderschöne Stockente.");
    }

}
