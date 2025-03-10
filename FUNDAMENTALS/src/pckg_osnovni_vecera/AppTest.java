package pckg_osnovni_vecera;

import pckg_outsource_vecera.Desert;
import pckg_outsource_vecera.GlavnoJelo;

public class AppTest {

    public static void main(String[] args) {
        Predjelo predjelo = new Predjelo("Juha od gljiva", 4.5);
        GlavnoJelo glavnojelo = new GlavnoJelo("Teleci but", 10.98);
        Desert desert = new Desert("Becka torta", 5);
        Vecera vecera = new Vecera(predjelo, glavnojelo, desert);
        double cijena = vecera.finalPrice();
        System.out.println("Za platiti: " + cijena);
    }
}
