package ohtu;

import javax.swing.JTextField;

public class Summa extends KenttiaKayttavaToiminto implements Komento{

    private Sovelluslogiikka sovellus;
    private int edellinenPlussattuArvo;

    public Summa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        super(tuloskentta, syotekentta);
        this.sovellus = sovellus;
    }

    @Override
    public void suorita() {
        edellinenPlussattuArvo = syoteKentanArvo();
        sovellus.plus(syoteKentanArvo());
        tuloskenttaanArvo(sovellus.tulos());
    }

    @Override
    public void peru() {
        sovellus.miinus(edellinenPlussattuArvo);
        tuloskenttaanArvo(sovellus.tulos());
        edellinenPlussattuArvo = 0;
    }
}
