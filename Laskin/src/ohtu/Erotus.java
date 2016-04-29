package ohtu;

import javax.swing.JTextField;

public class Erotus extends KenttiaKayttavaToiminto implements Komento {

    private Sovelluslogiikka sovellus;
    private int edellinenMiinustettuArvo;

    public Erotus(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        super(tuloskentta, syotekentta);
        this.sovellus = sovellus;
    }

    @Override
    public void suorita() {
        edellinenMiinustettuArvo = syoteKentanArvo();
        sovellus.miinus(syoteKentanArvo());
        tuloskenttaanArvo(sovellus.tulos());
    }

    @Override
    public void peru() {
        sovellus.plus(edellinenMiinustettuArvo);
        tuloskenttaanArvo(sovellus.tulos());
        edellinenMiinustettuArvo = 0;
    }
}
