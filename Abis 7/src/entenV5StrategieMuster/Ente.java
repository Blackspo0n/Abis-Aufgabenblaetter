package entenV5StrategieMuster;

/**
 *
 * Erste Erweiterung: Fliegende Enten
 */
public abstract class Ente {

    //Instanzvariablen für das Verhalten
    FlugVerhalten flugVerhalten;
    QuakVerhalten quakVerhalten;

    public void tuQuaken() {
        quakVerhalten.quaken();
    }

    public void schwimmen() {
        System.out.println("Ich schwimme auf dem See.");
    }

    public void tuFliegen() {
        flugVerhalten.fliegen();
    }

    public abstract void anzeigen();

    //GETTER und SETTER um das Verhalten zur Laufzeit zu ändern.
    public FlugVerhalten getFlugVerhalten() {
        return flugVerhalten;
    }

    public void setFlugVerhalten(FlugVerhalten flugVerhalten) {
        this.flugVerhalten = flugVerhalten;
    }

    public QuakVerhalten getQuakVerhalten() {
        return quakVerhalten;
    }

    public void setQuakVerhalten(QuakVerhalten quakVerhalten) {
        this.quakVerhalten = quakVerhalten;
    }

}
