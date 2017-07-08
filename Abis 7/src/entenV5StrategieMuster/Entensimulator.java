package entenV5StrategieMuster;

import java.util.ArrayList;

public class Entensimulator {
    
    private static void enteInAktion(Ente e) {
        e.anzeigen();
        e.tuQuaken();
        e.schwimmen();
        e.tuFliegen();
    }

    public static void main(String[] args) {
        ArrayList<Ente> entenliste = new ArrayList<Ente>();
        entenliste.add(new Stockente());
        entenliste.add(new Moorente());
        entenliste.add(new Gummiente());
        entenliste.add(new Lockente());

        for (int x=0; x < entenliste.size(); x++)
            enteInAktion(entenliste.get(x));
        
        entenliste.get(0).setQuakVerhalten(new Schreien());
        enteInAktion(entenliste.get(0));
    }

}
