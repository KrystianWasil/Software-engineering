import java.util.ArrayList;

interface Obserwator {
    void zaktualizuj(WynikMeczu wynikMeczu);
}

interface Obserwowany {
    void dodajObserwatora(Obserwator obserwator);
    void usunObserwatora(Obserwator obserwator);
    void powiadomObserwatorow(WynikMeczu wynikMeczu);
}

class WynikMeczu {
    private String druzynaGospodarzy;
    private String druzynaGosci;
    private int punktyGospodarzy;
    private int punktyGosci;
    //Konstruktor symukuje tutaj stowrzeie jakiegos meczu i jego wyniku
    public WynikMeczu(int punktyGospodarzy, int punktyGosci, String druzynaGospodarzy, String druzynaGosci) {
        this.punktyGospodarzy = punktyGospodarzy;
        this.punktyGosci = punktyGosci;
        this.druzynaGospodarzy = druzynaGospodarzy;
        this.druzynaGosci = druzynaGosci;
    }
    public String getDruzynaGospodarzy() {
        return druzynaGospodarzy;
    }
    public String getDruzynaGosci() {
        return druzynaGosci;
    }

    public int getPunktyGosci() {
        return punktyGosci;
    }
    public int getPunktyGospodarzy() {
        return punktyGospodarzy;
    }
}

class WynikiMeczowNaZywo implements Obserwowany {
    private ArrayList<WynikMeczu> dane;
    private ArrayList<Obserwator> obserwatorzy;

    public WynikiMeczowNaZywo() {
        dane = new ArrayList<>();
        obserwatorzy = new ArrayList<>();
    }

    public void pobierzDane(WynikMeczu wynikMeczu) {
        System.out.println("Dane pobrane i dodane do listy");
        dane.add(wynikMeczu);

    }


    @Override
    public void dodajObserwatora(Obserwator obserwator) {
        obserwatorzy.add(obserwator);
    }

    @Override
    public void usunObserwatora(Obserwator obserwator) {
        obserwatorzy.remove(obserwator);
    }

    @Override
    public void powiadomObserwatorow(WynikMeczu wynikMeczu) {
        for (Obserwator obserwator : obserwatorzy) {
            obserwator.zaktualizuj(wynikMeczu);
        }
    }
}

class Widz implements Obserwator {
    public int id = 0; //unikalne id dla każdego widza na potrzeby testow
    @Override
    public void zaktualizuj(WynikMeczu wynikMeczu) {
        System.out.println("Widz "+ this.id + " otrzymał aktualizację aktaulny wynik meczu: " + wynikMeczu.getDruzynaGosci()+  " : " + wynikMeczu.getDruzynaGospodarzy() + " " + wynikMeczu.getPunktyGosci() + " : " + wynikMeczu.getPunktyGospodarzy());

    }
}

public class ObserwatorMain {
    public static void main(String[] args) {
        //nasza kalsa odpowiedzalna za przechowywanie wyników meczów i powiadamianie obserwatorów
        WynikiMeczowNaZywo wynikiMeczowNaZywo = new WynikiMeczowNaZywo();
        //tworzymy obiekt klasy widz czyli obserwatora
        Widz widz1 = new Widz();
        widz1.id = 1;
        
        Widz widz2 = new Widz();
        widz2.id = 2;

        wynikiMeczowNaZywo.dodajObserwatora(widz1);
        wynikiMeczowNaZywo.dodajObserwatora(widz2);
        //mecz1
        WynikMeczu wynikMeczu = new WynikMeczu(2, 1, "Lech Poznań", "Legia Warszawa");
        //mecz2
        WynikMeczu wynikMeczu2 = new WynikMeczu(1, 1, "Wisla Krakow", "Lublin Motor");
        //akutalizacja wyników meczów
        wynikiMeczowNaZywo.pobierzDane(wynikMeczu);
        //powiadomienie obserwatorów o zmianie wyniku meczu
        wynikiMeczowNaZywo.powiadomObserwatorow(wynikMeczu);
        //aktualizacja wyników meczów 2
        wynikiMeczowNaZywo.pobierzDane(wynikMeczu2);
        //powiadomienie obserwatorów o zmianie wyniku meczu 2
        wynikiMeczowNaZywo.powiadomObserwatorow(wynikMeczu2);
        //usunięcie obserwatora
        wynikiMeczowNaZywo.usunObserwatora(widz1);
        //powiadamiam tlyko 1 obserwatora
        wynikiMeczowNaZywo.powiadomObserwatorow(wynikMeczu);
    

    }
}
