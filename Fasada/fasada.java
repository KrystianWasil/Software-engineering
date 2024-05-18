class Samochod {
    public Fasada fasada = new Fasada();
}

class Fasada {
    private Wydech wydech = new Wydech();
    private SkrzyniaBiegow skrzynia = new SkrzyniaBiegow();
    private Kierownica kierownica = new Kierownica();
    private FotelKierowcy fotelKierowcy = new FotelKierowcy();
    private FotelPasazera fotelPasazera = new FotelPasazera();

    public void wlaczTrybSport() {
        wydech.otworzWydech();
        skrzynia.trybSportAutomat();
        kierownica.wylaczWspomaganie();
        fotelKierowcy.ustawKubelkowe();
    }

    public void wlaczTrybEco() {
        wydech.zamknijWydech();
        skrzynia.trybEcoAutomat();
        kierownica.wlaczWspomaganie();
        fotelKierowcy.ustawRodzinne();
        fotelPasazera.ustawRodzinne();
    }
}



class Wydech {
    public void otworzWydech() {
        System.out.println("{Otwarto wydech}");
    }
    public void zamknijWydech() {
        System.out.println("{Zamknieto wydech}");
    }
}

class SkrzyniaBiegow {
    public void trybSportAutomat() {
        System.out.println("{Skrzyna biegow sportowa}");
    }
    public void trybEcoAutomat() {
        System.out.println("{Skrzyna biegow eco}");
    }
}

class Kierownica {
    public void wylaczWspomaganie() {
        System.out.println("Wylaczono wspomaganie");
    }
    public void wlaczWspomaganie() {
        System.out.println("{Wlaczono wspomaganie}");
    }
}

interface Fotel {
    void ustawKubelkowe();
    void ustawRodzinne();
}

class FotelKierowcy implements Fotel {
    @Override
    public void ustawKubelkowe() {
        System.out.println("{Ustawiono kubelkowe dla kierowcy}");
    }

    @Override
    public void ustawRodzinne() {
        System.out.println("{Ustawiono rodzinne dla kierowcy}");
    }

}

class FotelPasazera implements Fotel{
    @Override
    public void ustawKubelkowe() {

    }

    @Override
    public void ustawRodzinne() {
        System.out.println("{Ustaw rodzinne dla pasazera}");
    }
}
public class Main {
    public  static void main(String[] args) {
        Samochod samochod = new Samochod();
        samochod.fasada.wlaczTrybSport();
    }

}
