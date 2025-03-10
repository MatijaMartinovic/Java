package pckg_osnovni_vecera;

public class Predjelo {

    private String naziv;
    private double cijena;

    public Predjelo(String naziv, double cijena){
        this.cijena = cijena;
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return "Predjelo{" +
                "naziv='" + naziv + '\'' +
                ", cijena=" + cijena +
                '}';
    }

    String zadovoljstvoPredjelo(){
        return "Super";
    }

    public double getPrice() {
        return this.cijena;
    }
}
